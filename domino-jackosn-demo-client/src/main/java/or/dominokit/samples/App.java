package or.dominokit.samples;

import com.google.gwt.core.client.EntryPoint;
import elemental2.core.Global;
import elemental2.core.JsObject;
import elemental2.dom.DomGlobal;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import or.dominokit.samples.complex.Customer;
import or.dominokit.samples.complex.Customer_MapperImpl;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.jacksonapt.DefaultJsonSerializationContext;
import org.dominokit.jacksonapt.JsonSerializationContext;

import java.util.ArrayList;
import java.util.List;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        TextBox first_name = TextBox.create("First name");
        TextBox last_name = TextBox.create("Last name");

        DomGlobal.document.body
                .appendChild(Card.create()
                        .appendChild(Row.create()
                                .appendChild(Column.span6()
                                        .appendChild(first_name)
                                )
                        )
                        .appendChild(Row.create()
                                .appendChild(Column.span6()
                                        .appendChild(last_name)
                                )
                        )
                        .appendChild(Row.create()
                                .appendChild(Column.span6()
                                        .appendChild(Button.create("person with domino jackson")
                                                .addClickListener(evt -> {
                                                    Person person = new Person(first_name.getValue(), last_name.getValue());
                                                    DomGlobal.console.info(Person_MapperImpl.INSTANCE.write(person));
                                                })
                                        )
                                ).appendChild(Column.span6()
                                        .appendChild(Button.create("person with JSON.stringify")
                                                .addClickListener(evt -> {
                                                    Person person = new Person(first_name.getValue(), last_name.getValue());
                                                    DomGlobal.console.info(Global.JSON.stringify(person));
                                                })
                                        )
                                )
                        )
                        .appendChild(Row.create()
                                .appendChild(Column.span6()
                                        .appendChild(Button.create("PropertyMap with JSON.stringify")
                                                .addClickListener(evt -> {
                                                    JsPropertyMap<String> jsonMap= Js.cast(Js.asAny(JsObject.create(null)).asPropertyMap());
                                                    jsonMap.set("firstName", first_name.getValue());
                                                    jsonMap.set("lastName", last_name.getValue());
                                                    DomGlobal.console.info(Global.JSON.stringify(jsonMap));
                                                })
                                        )
                                )
                                .appendChild(Column.span6()
                                        .appendChild(Button.create("Complex DTO with domino-jackson")
                                                .addClickListener(evt -> {
                                                    Customer customer = Customer_MapperImpl.INSTANCE.read(JsonStrings.JSON_SAMPLE);
                                                    DomGlobal.console.info(customer);

                                                    JsonSerializationContext serializationContext = DefaultJsonSerializationContext.builder()
                                                            .indent(true)
                                                            .build();
                                                    DomGlobal.console.info(Customer_MapperImpl.INSTANCE.write(customer, serializationContext));

                                                    Customer customer1 = Customer_MapperImpl.INSTANCE.read(JsonStrings.JSON_SAMPLE);
                                                    Customer customer2 = Customer_MapperImpl.INSTANCE.read(JsonStrings.JSON_SAMPLE);
                                                    List<Customer> customers = new ArrayList<>();
                                                    customers.add(customer1);
                                                    customers.add(customer2);

                                                    DomGlobal.console.info(CustomerListMapperImpl.INSTANCE.write(customers, serializationContext));
                                                })
                                        )
                                )
                        )
                        .element());

    }


}
