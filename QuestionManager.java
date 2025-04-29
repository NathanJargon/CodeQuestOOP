import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionManager {
    public static String difficulty = "Easy"; // Default difficulty
    public static int currentQuestionIndex = 0;
    public static int score = 0;
    public static List<String[]> questions;

    private static final List<String[]> easyQuestions = new ArrayList<>();
    private static final List<String[]> mediumQuestions = new ArrayList<>();
    private static final List<String[]> hardQuestions = new ArrayList<>();

    public static void initializeQuestions() {
        // Manually add Easy questions
        easyQuestions.add(new String[]{"1. What does OOP stand for?", "Object-Oriented Programming", "Object-Oriented Process", "Only Object Programming", "Object-Oriented Principle", "Object-Oriented Programming"});
        easyQuestions.add(new String[]{"2. Which of these is a feature of OOP?", "Encapsulation", "Polymorphism", "Inheritance", "All of the above", "All of the above"});
        easyQuestions.add(new String[]{"3. What is a class in OOP?", "A blueprint for objects", "A type of variable", "A function", "None of the above", "A blueprint for objects"});
        easyQuestions.add(new String[]{"4. Which keyword is used to create a class in Java?", "class", "Class", "new", "create", "class"});
        easyQuestions.add(new String[]{"5. What is an object?", "Instance of a class", "A class", "A method", "A variable", "Instance of a class"});
        easyQuestions.add(new String[]{"6. Which language is purely Object-Oriented?", "Smalltalk", "C", "Python", "C++", "Smalltalk"});
        easyQuestions.add(new String[]{"7. What is encapsulation?", "Hiding data", "Showing data", "Deleting data", "Transferring data", "Hiding data"});
        easyQuestions.add(new String[]{"8. Which concept focuses on reusing code?", "Inheritance", "Abstraction", "Polymorphism", "Encapsulation", "Inheritance"});
        easyQuestions.add(new String[]{"9. What defines the state of an object?", "Fields", "Methods", "Constructors", "Classes", "Fields"});
        easyQuestions.add(new String[]{"10. Which keyword is used to inherit a class in Java?", "extends", "inherits", "implements", "inheritsFrom", "extends"});
        easyQuestions.add(new String[]{"11. Which of the following is not a pillar of OOP?", "Encapsulation", "Abstraction", "Compilation", "Polymorphism", "Compilation"});
        easyQuestions.add(new String[]{"12. Constructor is a ____?", "Special method", "Variable", "Constant", "Class", "Special method"});
        easyQuestions.add(new String[]{"13. What is the default access modifier in Java?", "Package-private", "Public", "Private", "Protected", "Package-private"});
        easyQuestions.add(new String[]{"14. Which of these is not a Java keyword?", "interface", "class", "object", "extends", "object"});
        easyQuestions.add(new String[]{"15. Which method is called when an object is created?", "Constructor", "Destructor", "Finalize", "Init", "Constructor"});
        easyQuestions.add(new String[]{"16. Which OOP principle supports method overriding?", "Polymorphism", "Encapsulation", "Abstraction", "Inheritance", "Polymorphism"});
        easyQuestions.add(new String[]{"17. Java supports multiple inheritance through ____?", "Interfaces", "Classes", "Objects", "Constructors", "Interfaces"});
        easyQuestions.add(new String[]{"18. Which function lets an object clean up resources before dying?", "finalize()", "destroy()", "delete()", "end()", "finalize()"});
        easyQuestions.add(new String[]{"19. The process of hiding the internal details is called?", "Abstraction", "Inheritance", "Polymorphism", "Encapsulation", "Abstraction"});
        easyQuestions.add(new String[]{"20. Method that has the same name but different parameters is?", "Overloading", "Overriding", "Shadowing", "Cloning", "Overloading"});
    
        // Manually add Medium questions
        mediumQuestions.add(new String[]{"1. What is polymorphism in OOP?", "Ability to take many forms", "Inheritance of classes", "Encapsulation of data", "None of the above", "Ability to take many forms"});
        mediumQuestions.add(new String[]{"2. What is method overloading?", "Same method name, different parameters", "Same method name, same parameters", "Different method names, same parameters", "None of the above", "Same method name, different parameters"});
        mediumQuestions.add(new String[]{"3. What is the purpose of an interface in OOP?", "To define a contract for classes", "To implement inheritance", "To encapsulate data", "None of the above", "To define a contract for classes"});
        mediumQuestions.add(new String[]{"4. What is method overriding?", "Same method name in child class", "Different method names", "Method with same signature in parent class", "None of the above", "Same method name in child class"});
        mediumQuestions.add(new String[]{"5. Which keyword prevents a class from being inherited?", "final", "static", "private", "protected", "final"});
        mediumQuestions.add(new String[]{"6. Abstract class can have?", "Abstract and non-abstract methods", "Only abstract methods", "Only static methods", "Only constructors", "Abstract and non-abstract methods"});
        mediumQuestions.add(new String[]{"7. Interface methods are?", "Public and abstract", "Private and abstract", "Protected and static", "None of the above", "Public and abstract"});
        mediumQuestions.add(new String[]{"8. What keyword is used to create an object in Java?", "new", "create", "make", "instance", "new"});
        mediumQuestions.add(new String[]{"9. Which is true about constructors?", "Constructor has the same name as class", "Constructor must return a value", "Constructor is private always", "Constructor needs static keyword", "Constructor has the same name as class"});
        mediumQuestions.add(new String[]{"10. Which access modifier makes members accessible in the same package?", "default", "private", "public", "protected", "default"});
        mediumQuestions.add(new String[]{"11. What is downcasting?", "Casting from superclass to subclass", "Casting from subclass to superclass", "Making a method final", "Hiding variables", "Casting from superclass to subclass"});
        mediumQuestions.add(new String[]{"12. Which class can never be instantiated?", "Abstract class", "Concrete class", "Static class", "Interface", "Abstract class"});
        mediumQuestions.add(new String[]{"13. What keyword is used to call the superclass constructor?", "super", "base", "parent", "this", "super"});
        mediumQuestions.add(new String[]{"14. The concept of having many classes with same method names but different behaviors is?", "Polymorphism", "Encapsulation", "Abstraction", "Inheritance", "Polymorphism"});
        mediumQuestions.add(new String[]{"15. Which allows multiple methods with same name in a class?", "Overloading", "Overriding", "Shadowing", "Cloning", "Overloading"});
        mediumQuestions.add(new String[]{"16. Can abstract classes have constructors?", "Yes", "No", "Only in interfaces", "Only in final classes", "Yes"});
        mediumQuestions.add(new String[]{"17. Which keyword is used to inherit an interface?", "implements", "extends", "inherits", "overrides", "implements"});
        mediumQuestions.add(new String[]{"18. What is the default value of an object reference in Java?", "null", "0", "empty", "undefined", "null"});
        mediumQuestions.add(new String[]{"19. What is an association between two classes called?", "Relationship", "Inheritance", "Composition", "Aggregation", "Association"});
        mediumQuestions.add(new String[]{"20. How many classes can a class extend in Java?", "One", "Two", "Unlimited", "Zero", "One"});
    
        // Manually add Hard questions
        hardQuestions.add(new String[]{"1. What is abstraction in OOP?", "Hiding implementation details", "Providing multiple inheritance", "Improving runtime performance", "None of the above", "Hiding implementation details"});
        hardQuestions.add(new String[]{"2. What is the diamond problem in OOP?", "A problem with multiple inheritance", "A problem with encapsulation", "A problem with polymorphism", "None of the above", "A problem with multiple inheritance"});
        hardQuestions.add(new String[]{"3. What is the purpose of a virtual function?", "To allow runtime polymorphism", "To define a static method", "To improve performance", "None of the above", "To allow runtime polymorphism"});
        hardQuestions.add(new String[]{"4. What is dynamic dispatch?", "Choosing which method to call at runtime", "Choosing method at compile time", "Assigning variable types at runtime", "None of the above", "Choosing which method to call at runtime"});
        hardQuestions.add(new String[]{"5. Which design principle states ‘program to interfaces, not implementation’?", "Dependency Inversion Principle", "Open/Closed Principle", "Single Responsibility Principle", "Liskov Substitution Principle", "Dependency Inversion Principle"});
        hardQuestions.add(new String[]{"6. What is late binding?", "Runtime method binding", "Compile-time method binding", "Static method call", "None of the above", "Runtime method binding"});
        hardQuestions.add(new String[]{"7. What is cohesion?", "Degree to which elements belong together", "Interdependence of modules", "Data hiding", "None of the above", "Degree to which elements belong together"});
        hardQuestions.add(new String[]{"8. Which is not a creational design pattern?", "Factory", "Singleton", "Observer", "Builder", "Observer"});
        hardQuestions.add(new String[]{"9. What is multiple inheritance?", "Class inherits from multiple classes", "Class has multiple interfaces", "Interface inherits from classes", "None of the above", "Class inherits from multiple classes"});
        hardQuestions.add(new String[]{"10. What is an inner class?", "Class within another class", "Class outside package", "Class extending itself", "None of the above", "Class within another class"});
        hardQuestions.add(new String[]{"11. What does SOLID stand for?", "Five design principles", "Object-oriented techniques", "Compilation rules", "None of the above", "Five design principles"});
        hardQuestions.add(new String[]{"12. Which concept solves method name collision in multiple inheritance?", "Interfaces", "Classes", "Objects", "Packages", "Interfaces"});
        hardQuestions.add(new String[]{"13. A constructor that takes no arguments is called?", "Default constructor", "Copy constructor", "Parameterized constructor", "Static constructor", "Default constructor"});
        hardQuestions.add(new String[]{"14. What is object slicing?", "Losing subclass-specific info when assigned to superclass", "Deleting an object", "Encapsulating data", "Overloading constructors", "Losing subclass-specific info when assigned to superclass"});
        hardQuestions.add(new String[]{"15. What is favor composition over inheritance?", "Use object composition rather than inheritance hierarchy", "Use static methods", "Use constructors instead of methods", "None of the above", "Use object composition rather than inheritance hierarchy"});
        hardQuestions.add(new String[]{"16. The observer pattern is an example of?", "Behavioral pattern", "Creational pattern", "Structural pattern", "None of the above", "Behavioral pattern"});
        hardQuestions.add(new String[]{"17. Java supports multiple inheritance of?", "Interfaces", "Classes", "Methods", "Packages", "Interfaces"});
        hardQuestions.add(new String[]{"18. Aggregation is?", "Has-a relationship", "Is-a relationship", "Uses-a relationship", "None of the above", "Has-a relationship"});
        hardQuestions.add(new String[]{"19. Which access modifier makes a member accessible everywhere?", "public", "private", "protected", "default", "public"});
        hardQuestions.add(new String[]{"20. What principle does Liskov Substitution Principle relate to?", "Subtypes must be substitutable for supertypes", "Inheritance from final classes", "Method overloading", "None of the above", "Subtypes must be substitutable for supertypes"});
    }
    

    public static void generateQuestions() {
        // Select the appropriate question pool based on difficulty
        List<String[]> questionPool;
        switch (difficulty) {
            case "Medium":
                questionPool = mediumQuestions;
                break;
            case "Hard":
                questionPool = hardQuestions;
                break;
            case "Easy":
            default:
                questionPool = easyQuestions;
                break;
        }

        // Ensure the questions are numbered from 1 to 20
        questions = new ArrayList<>(questionPool);
        for (int i = 0; i < questions.size(); i++) {
            String[] question = questions.get(i);
            question[0] = (i + 1) + ". " + question[0].substring(question[0].indexOf(" ") + 1);
        }
    }
}