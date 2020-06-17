package or.dominokit.samples;

import or.dominokit.samples.complex.Customer;
import org.dominokit.jacksonapt.ObjectMapper;
import org.dominokit.jacksonapt.annotation.JSONMapper;

import java.util.List;

@JSONMapper
public interface CustomerListMapper extends ObjectMapper<List<Customer>> {
}
