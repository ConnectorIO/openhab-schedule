package com.connectorio.bmshub.api;

import java.util.List;
import org.eclipse.smarthome.core.types.State;
import org.eclipse.smarthome.core.types.Type;

/**
 * Copy of the type parser signature from openhab core.
 */
public interface TypeAndStateParser {

    /**
     * Parses a string into a type.
     *
     * @param typeName name of the type, for example StringType.
     * @param input input string to parse.
     * @return Parsed type or null, if the type couldn't be parsed.
     */
    Type parseType(String typeName, String input);

    /**
     * <p>
     * Determines a state from a string. Possible state types are passed as a parameter. Note that the order matters
     * here; the first type that accepts the string as a valid value, will be used for the state.
     *
     * <p>
     * Example: The type list is OnOffType.class,StringType.class. The string "ON" is now accepted by the OnOffType and
     * thus OnOffType.ON will be returned (and not a StringType with value "ON").
     *
     * @param types possible types of the state to consider
     * @param state the string to parse
     * @return the corresponding State instance or <code>null</code>
     */
    State parseState(List<Class<? extends State>> types, String state);

}
