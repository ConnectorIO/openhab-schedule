package org.eclipse.smarthome.core.types;

import java.util.List;

public class TypeParser {

    protected static TypeParserDelegate delegate;

    private TypeParser() {}

    public static Type parseType(String typeName, String input) {
        return delegate.parseType(typeName, input);
    }

    public static State parseState(List<Class<? extends State>> types, String state) {
        return delegate.parseState(types, state);
    }

    static void initialize(TypeParserDelegate delegate) {
        TypeParser.delegate = delegate;
    }

}
