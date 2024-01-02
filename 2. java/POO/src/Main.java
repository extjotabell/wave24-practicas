import classes.Person;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static void bmiInterpretation(int bmi) {
        switch (bmi) {
            case -1:
                System.out.println("You are underweight.");
                break;
        
            case 0:
                System.out.println("You are healthy.");
                break;

            case 1:
                System.out.println("You are overweight.");
                break;

            default:
                System.out.println(
                    "Your Weight or Heigth has something wrong. Please, check it and try again."
                );
                break;
                
        }  
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Person p = new Person("Camilo", 25, "123456789");
        Person p2 = new Person("John", 90, "987654321");

        p2.setWeight((long) 24.9);
        p2.setHeight((long) 1.8);
        
        int bmiResult = p2.calculateBMI();
        System.out.println("BMI: " + bmiResult);
        bmiInterpretation(bmiResult);

        boolean hasFullAge = p2.hasFullAge();
        System.out.println(hasFullAge ? "Has full age." : "Doesn't is 18 years old yet.");

        System.out.println(p2.toString());
    }
}