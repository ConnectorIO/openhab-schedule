package org.eclipse.smarthome.core.types;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import com.connectorio.bmshub.api.TypeAndStateParser;

@Component(property = {"composite=true"})
public class TypeParserDelegate implements TypeAndStateParser {

    private final List<TypeAndStateParser> parsers = new CopyOnWriteArrayList<>();

    @Override
    public Type parseType(String typeName, String input) {
        return parsers.stream()
            .map(parser -> parser.parseType(typeName, input))
            .findFirst().orElseGet(() -> TypeParser.parseType(typeName, input));
    }

    @Override
    public State parseState(List<Class<? extends State>> types, String state) {
        return parsers.stream()
            .map(parser -> parser.parseState(types, state))
            .findFirst().orElseGet(() -> TypeParser.parseState(types, state));
    }

    @Activate
    public void activate() {
        TypeParser.initialize(this);
    }

    @Deactivate
    public void deactivate() {
        TypeParser.initialize(null);
    }

    @Reference
    public void addTypeParser(TypeAndStateParser parser) {
        this.parsers.add(parser);
    }

    @Reference
    public void removeTypeParser(TypeAndStateParser parser) {
        this.parsers.remove(parser);
    }

}
