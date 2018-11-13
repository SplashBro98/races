package task.epam.race.command;

import java.util.EnumMap;
import java.util.Optional;

public enum CommandMap {
    INSTANCE;

    private EnumMap<CommandType, Command> commandMap = new EnumMap<>(CommandType.class);

    public Optional<Command> getCommand(CommandType type){
        Command result = commandMap.get(type);
        if(result != null){
            return Optional.of(result);
        }
        return Optional.empty();
    }

    public void addCommand(CommandType type, Command command){
        commandMap.put(type, command);
    }

}
