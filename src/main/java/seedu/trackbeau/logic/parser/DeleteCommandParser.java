package seedu.trackbeau.logic.parser;

import static seedu.trackbeau.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.trackbeau.commons.core.index.Index;
import seedu.trackbeau.logic.commands.DeleteCommand;
import seedu.trackbeau.logic.parser.exceptions.ParseException;

import java.util.ArrayList;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        try {
            String[] split = args.split(",");
            ArrayList<Index> indexes = new ArrayList<>();
            for (String s : split) {
                indexes.add(ParserUtil.parseIndex(s));
            }
            //Index index = ParserUtil.parseIndex(split[0]);
            return new DeleteCommand(indexes);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE), pe);
        }
    }

}
