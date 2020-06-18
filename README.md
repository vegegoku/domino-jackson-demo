# Domino-jackson

### What is it :
- Annotation processing based JSON mappers. POJO -> JSON -> POJO

- It is a port of the original [gwt-jackson](https://github.com/nmorel/gwt-jackson)

- Works in GWT and J2CL, but also works in the JVM too.

### JSON mapping

- ##### JSON.stringify & JSON.parse
```java

JsPropertyMap<String> jsonMap= Js.cast(Js.asAny(JsObject.create(null)).asPropertyMap());
jsonMap.set("firstName", first_name.getValue());
jsonMap.set("lastName", last_name.getValue());

DomGlobal.console.info(Global.JSON.stringify(jsonMap));

```
    * Limited to JS types
 
    * Hard to use with Nested models.

    * Does not work with normal pojos unless they are exported as JsType, you can read about this here [JsInterop-DTO-strategy](https://github.com/intendia-oss/autorest/wiki/JsInterop-DTO-strategy)


-  ##### Domino-jackson

- Easy to use

- Support Jackson annotation

- Uses APT, no generators means faster GWT compile. j2cl friendly.

- Supports complex POJO structures, nested POJOs, enums, collections and nested collections..etc

- Annotate the POJO or annotate the Marker interface.

- Share the POJO and the Mapper with your server and client.

- Actively Maintained.
