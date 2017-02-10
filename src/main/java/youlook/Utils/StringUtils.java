package youlook.Utils;

import youlook.model.Record;

public class StringUtils {
    private final static char ZERO = '0';
    private final static char NINE = '9';

    public static Record getNewRecord(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("The str parameter can't be null or emtpy");
        }
        int position = 0;
        Integer currentDigitGroupPosition = 0;
        Integer totalCoutOfDigits = 0;
        boolean digitFinded = false;
        StringBuilder result = new StringBuilder();
        StringBuilder currentDigitGroup = new StringBuilder();

        for (char c : str.toCharArray()) {
            position++;
            //System.out.printf("%s %s %s%n", position, c, String.valueOf(c));
            if (c < ZERO || c > NINE) {
                if (digitFinded) {
                    messageConstructor(result, currentDigitGroup.toString(), currentDigitGroupPosition);
                    totalCoutOfDigits = totalCoutOfDigits + currentDigitGroup.length();
                    digitFinded = false;
                    currentDigitGroup = new StringBuilder();
                }
                continue;
            }

            currentDigitGroup.append(c);
            if (!digitFinded) {
                currentDigitGroupPosition = position;
                digitFinded = true;
            }

        }
        if (digitFinded) {
            messageConstructor(result, currentDigitGroup.toString(), currentDigitGroupPosition);
            totalCoutOfDigits = totalCoutOfDigits + currentDigitGroup.length();
        }
        result.append(Constant.TOTALMESSAGE).append(totalCoutOfDigits);
        result.insert(0, String.format("{%s}", totalCoutOfDigits) + Constant.NEWLINE);

        return new Record(str, totalCoutOfDigits, result.toString());
    }

    private static void messageConstructor(StringBuilder resultMessage, String stringBuilder, Integer currentDigitGroupPosition) {
        resultMessage.append(Constant.POSITION)
                .append(currentDigitGroupPosition)
                .append(Constant.LINE)
                .append(stringBuilder)
                .append(Constant.SIZE)
                .append(stringBuilder.length())
                .append(Constant.NEWLINE);
    }
}
