package test;

/**
 * Created by raghu on 1/27/2017.
 */
class FinalResult {
    public int first;
    public int next;
}


class testtt {

    public static void main(String[] args) {
        String a = "746209249";
        System.out.println(getLeastNumberDeletingDigits_2(a,5));
    }

    public static String getLeastNumberDeletingDigits_2(String number, int k) {
        String leastNumber = number;
        int start = 0;
        while (k > 0 && leastNumber.length() > 0) {
            FinalResult result = getNextDecreasing(leastNumber, start);
            if (result.first >= 0) {
                leastNumber = removeDigit(leastNumber, result.first);
            } else {
                leastNumber = removeDigit(leastNumber, leastNumber.length() - 1);
            }

            start = result.next;
            --k;
        }

        return leastNumber;
    }

    private static FinalResult getNextDecreasing(String number, int start) {
        int firstDecreasing = -1;
        int nextStart;

        for (int i = start; i < number.length() - 1; ++i) {
            int curDigit = number.charAt(i) - '0';
            int nextDigit = number.charAt(i + 1) - '0';
            if (curDigit > nextDigit) {
                firstDecreasing = i;
                break;
            }
        }

        if (firstDecreasing == 0) {
            nextStart = 0;
        } else if (firstDecreasing > 0) {
            nextStart = firstDecreasing - 1;
        } else {
            nextStart = number.length();
        }

        FinalResult result = new FinalResult();
        result.first = firstDecreasing;
        result.next = nextStart;

        return result;
    }

    private static String removeDigit(String number, int digitIndex) {
        String result = "";
        if (digitIndex > 0) {
            result = number.substring(0, digitIndex);
        }
        if (digitIndex < number.length() - 1) {
            result += number.substring(digitIndex + 1);
        }

        return result;
    }
}

