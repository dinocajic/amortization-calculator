import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        double interest_rate         = 3.75 / 100;
        double monthly_interest_rate = interest_rate / 12;
        double total_balance         = 184067;
        double monthly_mortgage      = 1263.40;
        double extra_monthly_payment = 5000;

        double current_monthly_interest_payment;
        double current_monthly_principal_payment;

        System.out.println("Amortization Calculator");
        System.out.println("Starting Balance: $" + total_balance);
        System.out.println("Monthly Payment: $" + monthly_mortgage);
        System.out.println("Extra Monthly Payment: $" + extra_monthly_payment);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Interest Payment | Principal Payment | Remaining Balance | Month");
        System.out.println("----------------------------------------------------------------");

        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);

        int i = 1;

        while( total_balance > 0 ) {
            current_monthly_interest_payment  = total_balance * monthly_interest_rate;
            current_monthly_principal_payment = monthly_mortgage - current_monthly_interest_payment;

            total_balance = total_balance - current_monthly_principal_payment;
            total_balance = total_balance - extra_monthly_payment;

            System.out.println(
                    fixedLengthString("$" + decimalFormat.format(current_monthly_interest_payment) + " | ", 19) +
                    fixedLengthString("$" + decimalFormat.format(current_monthly_principal_payment) + " | ", 20) +
                    fixedLengthString("$" + decimalFormat.format(total_balance) + " | ", 20) +
                    fixedLengthString(i + "", 5)
            );

            i++;
        }
    }

    public static String fixedLengthString(String string, int length) {
        return String.format("%1$" + length + "s", string);
    }
}
