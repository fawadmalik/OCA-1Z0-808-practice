Question 1: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
import java.util.ArrayList;
import java.util.List;
 
public class Test {
     public static void main(String[] args) {
         List<Integer> list = new ArrayList<>();
         list.add(100);
         list.add(200);
         list.add(100);
         list.add(200);
         list.remove(100);
 
         System.out.println(list);
     }
}
### Explanation
List cannot accept primitives, it can accept objects only. So, when 100 and 200 are added to the list, then auto-boxing feature converts these to wrapper objects of Integer type.

So, 4 items gets added to the list. One can expect the same behavior with remove method as well that 100 will be auto-boxed to Integer object.

But remove method is overloaded in List interface: remove(int) => Removes the element from the specified position in this list

and remove(Object)  => Removes the first occurrence of the specified element from the list.

As remove(int) version is available, which perfectly matches with the call remove(100); hence compiler does not do auto-boxing in this case.

But at runtime remove(100) tries to remove the element at 100th index and this throws IndexOutOfBoundsException.

Question 2: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String [] args) {
         int a = 100;
         System.out.println(-a++);
     }
}










Explanation
First add parenthesis (round brackets) to the given expression: -a++.

There are 2 operators involved. unary minus and Postfix operator. Let's start with expression and value of a.



-a++; [a = 100]. 

-(a++); [a = 100] Postfix operator has got higher precedence than unary operator.   

-(100); [a = 101] Use the value of a (100) in the expression and after that increase the value of a to 101. 

-100; [a = 101] -100 is printed on to the console.

Question 3: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         try {
             main(args);
         } catch (Exception ex) {
             System.out.println("CATCH-");
         }
             System.out.println("OUT");
     }
}








Explanation
main(args) method is invoked recursively without specifying any exit condition, so this code ultimately throws java.lang.StackOverflowError. StackOverflowError is a subclass of Error type and not Exception type, hence it is not handled. Stack trace is printed to the console and program ends abruptly.



Java doesn't allow to catch specific checked exceptions if these are not thrown by the statements inside try block.

catch(java.io.FileNotFoundException ex) {} will cause compilation error in this case as main(args); will never throw FileNotFoundException. But Java allows to catch Exception type, hence catch (Exception ex) {} doesn't cause any compilation error.

Question 4: Incorrect
Consider codes below:

//A.java
package com.udayan.oca;
 
public class A {
     public int i1 = 1;
     protected int i2 = 2;
}


//B.java
package com.udayan.oca.test;
 
import com.udayan.oca.A;
 
public class B extends A {
     public void print() {
         A obj = new A();
         System.out.println(obj.i1); //Line 8
         System.out.println(obj.i2); //Line 9
         System.out.println(this.i2); //Line 10
         System.out.println(super.i2); //Line 11
     }
 
     public static void main(String [] args) {
         new B().print();
     }
}
One of the statements inside print() method is causing compilation failure. Which of the below solutions will help to resolve compilation error?









Explanation
class A is declared public and defined in com.udayan.oca package, there is no problem in accessing class A outside com.udayan.oca package.

class B is defined in com.udayan.oca.test package, to extend from class A either use import statement "import com.udayan.oca.A;" or fully qualified name of the class com.udayan.oca.A. No issues with this class definition as well.



Variable i1 is declared public in class A, so Line 8 doesn't cause any compilation error. Variable i2 is declared protected so it can only be accessed in subclass using inheritance but not using object reference variable. obj.i2 causes compilation failure.



class B inherits variable i2 from class A, so inside class B it can be accessed by using either this or super. Line 10 and Line 11 don't cause any compilation error.

Question 5: Correct
Consider below code: 

//Test.java
package com.udayan.oca;
 
import java.time.LocalDate;
 
public class Test {
    public static void main(String [] args) {
        LocalDate newYear = LocalDate.of(2018, 1, 1);
        LocalDate christmas = LocalDate.of(2018, 12, 25);
        boolean flag1 = newYear.isAfter(christmas);
        boolean flag2 = newYear.isBefore(christmas);
        System.out.println(flag1 + ":" + flag2);
    }
}
What will be the result of compiling and executing Test class?









Explanation
isAfter and isBefore method can be interpreted as:

Does 1st Jan 2018 come after 25th Dec 2018? No, false. 

Does 1st Jan 2018 come before 25th Dec 2018? Yes, true.

Question 6: Incorrect
Consider below code:

//Guest.java
class Message {
     static void main(String [] args) {
         System.out.println("Welcome! " + args[1]);
     }
}
 
public class Guest {
     public static void main(String [] args) {
         Message.main(args);
     }
}
And the commands:
javac Guest.java
java Guest James Gosling

What is the result?











Explanation
Class Guest has special main method but main method defined in Message class is not public and hence it can't be called by JVM. But there is no issue with the syntax hence no compilation error.

java Guest James Gosling passes new String [] {"James", "Gosling"} to args of Guest.main method.

Guest.main method invokes Message.main method with the same argument: new String [] {"James", "Gosling"}. args[1] is "Gosling" hence "Welcome! Gosling" gets printed on to the console.

Question 7: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         String fruit = "mango";
         switch (fruit) {
             default:
                 System.out.println("ANY FRUIT WILL DO");
             case "Apple":
                 System.out.println("APPLE");
             case "Mango":
                 System.out.println("MANGO");
             case "Banana":
                 System.out.println("BANANA");
                 break;
         }
     }
}








Explanation
"mango" is different from "Mango", so there is no matching case available. default block is executed, "ANY FRUIT WILL DO" is printed on to the screen.

No break statement inside default, hence control enters in fall-through and executes remaining blocks until the break; is found or switch block ends.

So in this case, it prints APPLE, MANGO, BANANA one after another and break; statement takes control out of switch block. main method ends and program terminates successfully.

Question 8: Incorrect
Consider below code fragment:

interface Printable {
     public void setMargin();
     public void setOrientation();
}
 
abstract class Paper implements Printable { //Line 7
     public void setMargin() {}
     //Line 9
}
 
class NewsPaper extends Paper { //Line 12
     public void setMargin() {}
     //Line 14
}
Above code is currently giving compilation error. Which 2 modifications, done independently, enable the code to compile?









Explanation
First you should find out the reason for compilation error. Methods declared in Printable interface are implicitly abstract, no issues with Printable interface.



class Paper is declared abstract and it implements Printable interface, it overrides setMargin() method but setOrientation() method is still abstract. No issues with class Paper as it is an abstract class and can have 0 or more abstract methods. 



class NewsPaper is concrete class and it extends Paper class (which is abstract). So class NewsPaper must override setOrientation() method OR it must be declared abstract.



Replacing Line 9 with 'public abstract void setOrientation();' is not necessary and it will not resolve the compilation error in NewsPaper class.



Replacing Line 7 with 'class Paper implements Printable {' will cause compilation failure of Paper class as it inherits abstract method 'setOrientation'.

Question 9: Correct
Consider below code: 

//Test.java
package com.udayan.oca;
 
import java.time.Period;
 
public class Test {
     public static void main(String [] args) {
         Period period = Period.of(0, 0, 0);
         System.out.println(period);
     }
}
What will be the result of compiling and executing Test class?









Explanation
Period.of(0, 0, 0); is equivalent to Period.ZERO. ZERO period is displayed as P0D, other than that, Period components (year, month, day) with 0 values are ignored. 



toString()'s result starts with P, and for non-zero year, Y is appended; for non-zero month, M is appended; and for non-zero day, D is appended. P,Y,M and D are in upper case. 



NOTE: Period.parse(CharSequence) method accepts the String parameter in "PnYnMnD" format, over here P,Y,M and D can be in any case.

Question 10: Correct
Consider below code: 

//Test.java
package com.udayan.oca;
 
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
 
public class Test {
     public static void main(String [] args) {
         LocalDate date = LocalDate.of(2012, 1, 11);
         Period period = Period.ofMonths(2);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
         System.out.print(formatter.format(date.minus(period)));
     }
}
What will be the result of compiling and executing Test class?











Explanation
date --> {2012-01-11}, period --> {P2M}, date.minus(period) --> {2011-11-11} [subtract 2 months period from {2012-01-11}, month is changed to 11 and year is changed to 2011].



formatter -> {MM-dd-yy}, when date {2011-11-11} is formatter in this format 11-11-11 is printed on to the console.

Question 11: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
class Message {
     String msg = "Happy New Year!";
 
     public void print() {
         System.out.println(msg);
     }
}
 
public class Test {
     public static void change(Message m) {
         m = new Message();
         m.msg = "Happy Holidays!";
     }
 
     public static void main(String[] args) {
         Message obj = new Message();
         obj.print();
         change(obj);
         obj.print();
     }
}








Explanation
It is pass-by-reference scheme.

Initially, msg = "Happy New Year!"

Call to method change(Message) doesn't modify the msg property of passed object rather it creates another Message object and modifies the msg property of new object to "Happy Holidays!"

So, the instance of Message referred by obj remains unchanged.

Hence in the output, you get:

Happy New Year!

Happy New Year!

Question 12: Correct
What will be the result of compiling and executing the Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         int grade = 60;
         if(grade = 60)
             System.out.println("You passed...");
         else
             System.out.println("You failed...");
     }
}








Explanation
Following are allowed in boolean expression of if statement:

1. Any expression whose result is either true or false. e.g. age > 20 

2. A boolean variable. e.g. flag 

3. A boolean literal: true or false 

4. A boolean assignment. e.g. flag = true 



boolean expression in this case is: (grade = 60), which is an int assignment and not boolean assignment. Hence Compilation error.

Question 13: Incorrect
Consider below code:

//Test.java
package com.udayan.oca;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
 
class Employee {
     private String name;
     private int age;
     private double salary;
 
     public Employee(String name, int age, double salary) {
         this.name = name;
         this.age = age;
         this.salary = salary;
     }
 
     public String getName() {
         return name;
     }
 
    public int getAge() {
         return age;
     }
 
    public double getSalary() {
         return salary;
     }
 
    public String toString() {
         return name;
     }
}
 
public class Test {
     public static void main(String [] args) {
         List<Employee> list = new ArrayList<>();
         list.add(new Employee("James", 25, 15000));
         list.add(new Employee("Lucy", 23, 12000));
         list.add(new Employee("Bill", 27, 10000));
         list.add(new Employee("Jack", 19, 5000));
         list.add(new Employee("Liya", 20, 8000));
 
         process(list, /*INSERT*/);
 
         System.out.println(list);
     }
 
     private static void process(List<Employee> list, Predicate<Employee> predicate) {
         Iterator<Employee> iterator = list.iterator();
         while(iterator.hasNext()) {
             if(predicate.test(iterator.next()))
             iterator.remove();
         }
      }
}
Which of the following lambda expressions, if used to replace /*INSERT*/, prints [Jack, Liya] on to the console?











Explanation
Jack's salary is 5000 and Liya's salary is 8000. If Employee's salary is >= 10000 then that Employee object is removed from the list.



Allowed lambda expression is: 

(Employee e) -> { return e.getSalary() >= 10000; }, 

Can be simplified to:  (e) -> { return e.getSalary() >= 10000; } => type can be removed from left side of the expression. 

Further simplified to: e -> { return e.getSalary() >= 10000; } => if there is only one parameter in left part, then round brackets (parenthesis) can be removed. 

Further simplified to: e -> e.getSalary() >= 10000 => if there is only one statement in the right side then semicolon inside the body, curly brackets and return statement can be removed. But all 3 [return, {}, ;] must be removed together.



NOTE: there should not be any space between - and > of arrow operator.

Question 14: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
import java.io.FileNotFoundException;
import java.io.IOException;
 
abstract class Super {
     public abstract void m1() throws IOException;
}
 
class Sub extends Super {
     @Override
     public void m1() throws IOException {
         throw new FileNotFoundException();
     }
}
 
public class Test {
     public static void main(String[] args) {
         Super s = new Sub();
         try {
             s.m1();
         } catch (FileNotFoundException e) {
             System.out.print("M");
         } finally {
             System.out.print("N");
         }
     }
}








Explanation
Even though an instance of FileNotFoundException is thrown by method m1() at runtime, but method m1() declares to throw IOException.

Reference variable s is of Super type and hence for compiler, call to s.m1(); is to method m1() of Super, which throws IOException.

And as IOException is checked exception hence calling code should handle it.



As calling code doesn't handle IOException or its super type, so s.m1(); gives compilation error.

Question 15: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         String [] fruits = {"apple", "banana", "mango", "orange"};
         for(String fruit : fruits) {
             System.out.print(fruit + " ");
             if(fruit.equals("mango")) {
                 continue;
             }
             System.out.println("salad!");
             break;
         }        
     }
}










Explanation
break; and continue; are used inside for-loop, hence no compilation error. In first iteration "apple " is printed on to the console. Cursor remains on the same line as print method is used and not println. boolean expression of if-block returns false, control goes just after if-block and appends "salad!" on to the console.

break; statement takes the control out of for loop, main method ends and program terminates successfully.



So in the console, you get "apple salad!"

Question 16: Correct
Consider below code:

//Test.java
package com.udayan.oca;
 
import java.time.LocalDate;
 
public class Test {
     public static void main(String [] args) {
          LocalDate date = LocalDate.of(2020, 9, 31);
          System.out.println(date);
     }
}
What will be the result of compiling and executing Test class?









Explanation
LocalDate.of(...) method first validates year, then month and finally day of the month. 

September can't have 31 days so LocalDate.of(...) method throws an instance of java.time.DateTimeException class.

Question 17: Correct
Fill in the blanks for the definition of java.lang.Error class:

public class java.lang.Error extends ________________ {...}







Explanation
An Error is a subclass of Throwable class.
Question 18: Correct
Consider below code: 

//Test.java
package com.udayan.oca;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
public class Test {
     public static void main(String[] args) {
         List<String> dryFruits = new ArrayList<>();
         dryFruits.add("Walnut");
         dryFruits.add("Apricot");
         dryFruits.add("Almond");
         dryFruits.add("Date");
 
         Iterator<String> iterator = dryFruits.iterator();
         while(iterator.hasNext()) {
             String dryFruit = iterator.next();
             if(dryFruit.startsWith("A")) {
                 dryFruits.remove(dryFruit);
             }
         }
        
         System.out.println(dryFruits);
    }
}
What will be the result of compiling and executing Test class?









Explanation
ConcurrentModificationException exception may be thrown for following condition:

1. Collection is being iterated using Iterator/ListIterator or by using for-each loop.

And

2. Execution of Iterator.next(), Iterator.remove(), ListIterator.previous(), ListIterator.set(E) & ListIterator.add(E) methods. These methods may throw java.util.ConcurrentModificationException in case Collection had been modified by means other than the iterator itself, such as Collection.add(E) or Collection.remove(Object) or List.remove(int) etc.



For the given code, 'dryFruits' list is being iterated using the Iterator<String>.

hasNext() method of Iterator has following implementation:

public boolean hasNext() {
    return cursor != size;
}
Where cursor is the index of next element to return and initially it is 0.



1st Iteration: cursor = 0, size = 4, hasNext() returns true. iterator.next() increments the cursor by 1 and returns "Walnut".

2nd Iteration: cursor = 1, size = 4, hasNext() returns true. iterator.next() increments the cursor by 1 and returns "Apricot". As "Apricot" starts with "A", hence dryFruits.remove(dryFruit) removes "Apricot" from the list and hence reducing the list's size by 1, size becomes 3.

3rd Iteration: cursor = 2, size = 3, hasNext() returns true. iterator.next() method throws java.util.ConcurrentModificationException.



If you want to remove the items from ArrayList, while using Iterator or ListIterator, then use Iterator.remove() or ListIterator.remove() method and NOT List.remove(...) method. Using List.remove(...) method while iterating the list (using the Iterator/ListIterator or for-each) may throw java.util.ConcurrentModificationException.

Question 19: Incorrect
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         String str = "java";
         StringBuilder sb = new StringBuilder("java");
 
         System.out.println(str.equals(sb) + ":" + sb.equals(str));
     }
}










Explanation
equals method declared in Object class has the declaration: public boolean equals(Object). Generally, equals method is used to compare different instances of same class but if you pass any other object, there is no compilation error. Parameter type is Object so it can accept any Java object.



str.equals(sb) => String class overrides equals(Object) method but as "sb" is of StringBuilder type so this returns false.



StringBuilder class doesn't override equals(Object) method. So Object version is invoked which uses == operator, hence sb.equals(str) returns false as well.



false:false is printed on to the console.

Question 20: Correct
What will be the result of compiling and executing Test class?

//Test.java
package com.udayan.oca.test;
 
abstract class Animal {
     private String name;
 
     Animal(String name) {
        this.name = name;
     }
 
     public String getName() {
         return name;
     }
}
 
class Dog extends Animal {
     private String breed;
     Dog(String breed) {
         this.breed = breed;
     }
 
     Dog(String name, String breed) {
         super(name);
         this.breed = breed;
     }
 
     public String getBreed() {
         return breed;
     }
}
 
public class Test {
     public static void main(String[] args) {
         Dog dog1 = new Dog("Beagle");
         Dog dog2 = new Dog("Bubbly", "Poodle");
         System.out.println(dog1.getName() + ":" + dog1.getBreed() + ":" + 
                             dog2.getName() + ":" + dog2.getBreed());
     }
}












Explanation
abstract class can have constructors and it also possible to have abstract class without any abstract method. So, there is no issue with Animal class.



Java compiler adds super(); as the first statement inside constructor, if call to another constructor using this(...) or super(...) is not available. 



Inside Animal class Constructor, compiler adds super(); => Animal(String name) { super(); this.name = name; }, super() in this case invokes the no-arg constructor of Object class and hence no compilation error here. 



Compiler changes Dog(String) constructor to: Dog(String breed) { super(); this.breed = breed; }. No-arg constructor is not available in Animal class and as another constructor is provided, java compiler doesn't add default constructor. Hence Dog(String) constructor gives compilation error.



There is no issue with Dog(String, String) constructor.

Question 21: Correct
Consider the code of Test.java file:

package com.udayan.oca;
 
class Student {
     String name;
     int age;
 
     void Student() {
         Student("James", 25);
     }
 
     void Student(String name, int age) {
         this.name = name;
         this.age = age;
     }
}
 
public class Test {
     public static void main(String[] args) {
         Student s = new Student();
         System.out.println(s.name + ":" + s.age);
     }
}
What will be the result of compiling and executing Test class?









Explanation
Methods can have same name as the class. Student() and Student(String, int) are methods and not constructors of the class, note the void return type of these methods.

As no constructors are provided in the Student class, java compiler adds default no-arg constructor. That is why the statement Student s = new Student(); doesn't give any compilation error.



Default values are assigned to instance variables, hence null is assigned to name and 0 is assigned to age. 



In the output, null:0 is displayed.

Question 22: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(null).length());
    }
}








Explanation
'append' method is overloaded in StringBuilder class: append(String), append(StringBuffer) and append(char[]) etc.

In this case compiler gets confused as to which method `append(null)` can be tagged because String, StringBuffer and char[] are not related to each other in multilevel inheritance. Hence `sb.append(null)` causes compilation error.

Question 23: Correct
Consider code below:

package com.udayan.oca;
 
class PenDrive {
     int capacity;
     PenDrive(int capacity) {
         this.capacity = capacity;
     }
}
 
class OTG extends PenDrive {
     String type;
     OTG(int capacity, String type) {
         //TODO
     }
}
 
public class Test {
     public static void main(String[] args) {
         OTG obj = new OTG(64, "TYPE-C");
         System.out.println(obj.capacity + ":" + obj.type);
     }
}
 
Currently above code is giving compilation error. 

Which of the options can successfully replace //TODO statement such that on executing Test class, output is 64:TYPE-C?






Explanation
Java compiler adds super(); as the first statement inside constructor, if call to another constructor using this(...) or super(...) is not available. 

Compiler adds super(); as the first line in OTG's constructor: OTG(int capacity, String type) { super(); } but PenDrive class doesn't have a no-arg constructor and that is why OTG's constructor gives compilation error.

To correct the compilation error, parent class constructor should be invoked by using super(capacity); This would resolve compilation error.

super(capacity); will only assign value to capacity property, to assign value to type another statement is needed.

this.type = type; must be the 2nd statement.



Remember: Constructor call using this(...) or super(...) must be the first statement inside the constructor.

Question 24: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
import java.util.function.Predicate;
 
public class Test {
     public static void main(String[] args) {
         String [] arr = {"A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab"};
 
         Predicate<String> p = s -> s.toUpperCase().substring(0,1).equals("A");
 
         processStringArray(arr, p);
     }
 
     private static void processStringArray(String [] arr, 
                                                Predicate<String> predicate) {
         for(String str : arr) {
             if(predicate.test(str)) {
                 System.out.println(str);
             }
         }
     }
}










Explanation
Let us suppose test string is "aba".

Lambda expression s.toUpperCase().substring(0,1).equals("A"); means: "aba".toUpperCase().substring(0,1).equals("A"); => "ABA".substring(0,1).equals("A"); => "A".equals("A"); => true.



This lambda expression returns true for any string starting with a (in lower or upper case).  Based on the lambda expression, 5 array elements passes the Predicate's test and are printed on to the console.

Question 25: Correct
Which of the following statement is correct about below code?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         do {
             System.out.println(100);
         } while (false);
         System.out.println("Bye");
     }
}








Explanation
As do-while loop executes at least once, hence none of the code is unreachable in this case. 

Java runtime prints 100 to the console, then it checks boolean expression, which is false. 

Hence control goes out of do-while block. Java runtime executes 2nd System.out.println statement to print "Bye" on to the console.

Question 26: Correct
____________ uses access modifiers to protect variables and hide them within a class.

Which of the following options accurately fill in the blanks above?









Explanation
Encapsulation is all about having private instance variable and providing public getter and setter methods.
Question 27: Correct
Consider the following class:

package com.udayan.oca;
 
public class Employee {
     public int passportNo; //line 2
}
Which of the following is the correct way to make the variable 'passportNo' read only for any other class?









Explanation
'passportNo' should be read-only for any other class.

This means make 'passportNo' private and provide public getter method. Don't provide public setter as then 'passportNo' will be read-write property.

If passportNo is declared with default scope, then other classes in the same package will be able to access passportNo for read-write operation.

Question 28: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         byte var = 100;
         switch(var) {
             case 100:
                 System.out.println("var is 100");
                 break;
             case 200:
                 System.out.println("var is 200");
                 break;
             default:
                 System.out.println("In default");
         }
     }
}








Explanation
case values must evaluate to the same type / compatible type as the switch expression can use. 

switch expression can accept following: 

char or Character 

byte or Byte 

short or Short 

int or Integer 

An enum only from Java 6 

A String expression only from Java 7 



In this case, switch expression [switch (var)] is of byte type.

byte range is from -128 to 127. But in case expression [case 200], 200 is outside byte range and hence compilation error.

Question 29: Correct
What will be the result of compiling and executing Test class?

//Test.java
package com.udayan.oca;
 
class Student {
     String name;
     int marks;
 
     Student(String name, int marks) {
         this.name = name;
         this.marks = marks;
     }
}
 
public class Test {
     public static void main(String[] args) {
         Student student = new Student("James", 25);
         int marks = 25;
         review(student, marks);
         System.out.println(marks + "-" + student.marks);
     }
 
     private static void review(Student stud, int marks) {
         marks = marks + 10;
         stud.marks+=marks;
     }
}








Explanation
This question checks your knowledge of pass-by-value and pass-by-reference schemes.

In below statements: student<main> means student inside main method.

On execution of main method: student<main> --> {"James", 25}, marks<main> = 25.

On execution of review method: stud<review> --> {"James", 25} (same object referred by student<main>), marks<review> = 25 (this marks is different from the marks defined in main method). marks<review> = 35 and stud.marks = 60. So at the end of review method: stud<review> --> {"James", 60}, marks<review> = 35.

Control goes back to main method: student<main> --> {"James", 60}, marks<main> = 25. Changes done to reference variable are visible in main method but changes done to primitive variable are not reflected in main method.

Question 30: Incorrect
For the class Test, which options, if used to replace /*INSERT*/, will print "Hurrah! I passed..." on to the console?

public class Test {
     /*INSERT*/ {
         System.out.println("Hurrah! I passed...");
     }
}












Explanation
As System.out.println needs to be executed on executing the Test class, this means special main method should replace /*INSERT*/.

Special main method's name should be "main" (all characters in lower case), should be static, should have public access specifier and it accepts argument of String [] type. String [] argument can use any identifier name, even though in most of the cases you will see "args" is used.

Position of static and public can be changed but return type must come just before the method name.

Question 31: Correct
Consider below code: 

//Test.java
package com.udayan.oca;
 
import java.util.ArrayList;
import java.util.List;
 
public class Test {
     public static void main(String[] args) {
         String s = new String("Hello");
         List<String> list = new ArrayList<>();
         list.add(s);
         list.add(new String("Hello"));
         list.add(s);
         s.replace("l", "L");
 
         System.out.println(list);
     }
}
What will be the result of compiling and executing Test class?









Explanation
ArrayList's 1st and 3rd items are referring to same String instance referred by s [s --> "Hello"] and 2nd item is referring to another instance of String.



String is immutable, which means s.replace("l", "L"); creates another String instance "HeLLo" but s still refers to "Hello" [s --> "Hello"]. 



[Hello, Hello, Hello] is printed in the output.

Question 32: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         int x = 1;
         while(checkAndIncrement(x)) {
             System.out.println(x);
         }
     }
 
     private static boolean checkAndIncrement(int x) {
         if(x < 5) {
             x++;
             return true;
         } else {
             return false;
         }
     }
}








Explanation
This is an example of pass-by-value scheme. x of checkAndIncrement method contains the copy of variable x defined in main method. So, changes done to x in checkAndIncrement method are not reflected in the variable x of main. x of main remains 1 as code inside main is not changing its value.



Every time checkAndIncrement method is invoked with argument value 1, so true is returned always and hence while loop executed indefinitely.

Question 33: Correct
Consider below code:

//Test.java
package com.udayan.oca;
 
class SpecialString {
     String str;
     SpecialString(String str) {
         this.str = str;
     }
}
 
public class Test {
     public static void main(String[] args) {
         System.out.println(new String("Java"));
         System.out.println(new StringBuilder("Java"));
         System.out.println(new SpecialString("Java"));
     }
}
What will be the result of compiling and executing Test class?









Explanation
String and StringBuilder classes override toString() method, which prints the text stored in these classes.

SpecialString class doesn't override toString() method and hence when instance of SpecialString is printed on to the console, you get: <fully qualified name of SpecialString class>@<hexadecimal representation of hashcode>.

Question 34: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
 
public class Test {
     public static void main(String[] args) {
         List<LocalDate> dates = new ArrayList<>();
         dates.add(LocalDate.parse("2018-07-11"));
         dates.add(LocalDate.parse("1919-02-25"));
         dates.add(LocalDate.of(2020, 4, 8));
         dates.add(LocalDate.of(1980, Month.DECEMBER, 31));
 
         dates.removeIf(x -> x.getYear() < 2000);
 
         System.out.println(dates);
     }
}








Explanation
LocalDate objects can be created by using static method parse and of.

removeIf(Predicate) method was added as a default method in Collection interface in JDK 8 and it removes all the elements of this collection that satisfy the given predicate. 



Predicate's test method returns true for all the LocalDate objects with year less than 2000. So all the LocalDate objects with year value less than 2000 are removed from the list. Remaining LocalDate objects are printed in their insertion order.

Question 35: Correct
How many objects of Pen class are eligible for Garbage Collection at Line 4?

package com.udayan.oca;
 
class Pen {
     
}
 
public class TestPen {
     public static void main(String[] args) {
         new Pen(); //Line 1
         Pen p = new Pen(); // Line 2
         change(p); //Line 3
         System.out.println("About to end."); //Line 4
     }
 
     public static void change(Pen pen) { //Line 5
         pen = new Pen(); //Line 6
     }
}








Explanation
Object created at Line 1 becomes eligible for Garbage collection after Line 1 only, as there are no references to it. So We have one object marked for GC. 

Object created at Line 6 becomes unreachable after change(Pen) method pops out of the STACK, and this happens after Line 3.

So at Line 4, we have two Pen objects eligible for Garbage collection: Created at Line 1 and Created at Line 6.

Question 36: Correct
Given the code of Test.java file:

package com.udayan.oca;
 
class Point {
     int x;
     int y;
     void assign(int x, int y) {
         x = this.x;
         this.y = y;
     }
 
     public String toString() {
         return "Point(" + x + ", " + y + ")";
     }
}
 
public class Test {
     public static void main(String[] args) {
         Point p1 = new Point();
         p1.x = 10;
         p1.y = 20;
         Point p2 = new Point();
         p2.assign(p1.x, p1.y);
         System.out.println(p1.toString() + ";" + p2.toString());
     }
}
What will be the result of compiling and executing Test class?











Explanation
HINT: First check if members are accessible or not. All the codes are in same file Test.java, and Point class & variable x, y are declared with default modifier hence these can be accessed within the same package. Class Test belongs to same package so no issues in accessing Point class and instance variables of Point class. Make use of pen and paper to draw the memory diagrams (heap and stack). It will be pretty quick to reach the result.



Point p1 = new Point(); means p1.x = 0 and p1.y = 0 as instance variable are initialized to respective zeros. 

p1.x = 10; means replace 0 with 10 in p1.x, 

p1.y = 20; means replace 0 with 20 in p1.y, 



Point p2 = new Point(); means p2.x = 0 and p2.y = 0 as instance variable are initialized to respective zeros. 

p2.assign(p1.x, p1.y); invokes the assign method, parameter variable x = 10 and y = 20.

As assign is invoked on p2 reference variable hence this and p2 refers to same Point object.

x = this.x; means assign 0 to parameter variable x, no changes in this.y, which means p2.x is unchanged. 

this.y = y; means assign 20 to this.y, which means p2.y is now 20

So after assign method is invoked and control goes back to main method: p1.x = 10, p1.y = 20, p2.x = 0 and p2.y = 20. 

Output is: Point(10, 20);Point(0, 20)

Question 37: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     private static void m(int x) {
         System.out.println("int version");
     }
 
     private static void m(char x) {
         System.out.println("char version");
     }
 
     public static void main(String [] args) {
         int i = '5';
         m(i);
         m('5');
     }
}










Explanation
Method m is overloaded. Which overloaded method to invoke is decided at compile time. m(i) is tagged to m(int) as i is of int type and m('5') is tagged to m(char) as '5' is char literal.
Question 38: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
import java.time.LocalTime;
 
public class Test {
     public static void main(String[] args) {
         LocalTime time = LocalTime.of(16, 40);
         String amPm = time.getHour() >= 12 ? (time.getHour() == 12) ? "PM" : "AM";
         System.out.println(amPm);
     }
}








Explanation
This question is on ternary operator (?:). If an expression has multiple ternary operators then number of ? and : should match.

Given expression contains 2 ? and 1 : and hence Compilation Error.

Question 39: Correct
Consider codes below:

//A.java
package com.udayan.oca;
 
public class A {
     public void print() {
         System.out.println("A");
     }
}


//B.java
package com.udayan.oca;
 
public class B extends A {
     public void print() {
         System.out.println("B");
     }
}


//Test.java
package com.udayan.oca.test;
 
import com.udayan.oca.*;
 
public class Test {
     public static void main(String[] args) {
         A obj1 = new A();
         B obj2 = (B)obj1;
         obj2.print();
     }
}
What will be the result of compiling and executing Test class?









Explanation
Class A and B are declared public and inside same package com.udayan.oca. Method print() of class A has correctly been overridden by B.

print() method is public so no issues in accessing it anywhere.



Let's check the code inside main method.

A obj1 = new A(); => obj1 refers to an instance of class A.

B obj2 = (B)obj1; => obj1 is of type A and it is assigned to obj2 (B type), hence explicit casting is necessary. obj1 refers to an instance of class A, so at runtime obj2 will also refer to an instance of class A. sub type can't refer to an object of super type so at runtime B obj2 = (B)obj1; will throw ClassCastException.

Question 40: Correct
Consider 3 files:

//Order.java
package orders;
 
public class Order {
    
}


//Item.java
package orders.items;
 
public class Item {
    
}


//Shop.java
package shopping;
 
/*INSERT*/
 
public class Shop {
     Order order = null;
     Item item = null;
}
For the class Shop, which options, if used to replace /*INSERT*/, will resolve all the compilation errors? Select 2 options.








Explanation
If you check the directory structure, you will find that directory "orders" contains "items", but orders and orders.items are different packages.import orders.*; will only import all the classes in orders package but not in orders.items package.

You need to import Order and Item classes. To import Order class, use either import orders.Order; OR import orders.*; and to import Item class, use either import orders.items.Item; OR import orders.items.*;

Question 41: Correct
Below is the code of Test.java file:

package com.udayan.oca;
 
import java.util.ArrayList;
import java.util.List;
 
public class Test {
     public static void main(String [] args) {
         List<Integer> list = new ArrayList<Integer>();
         list.add(new Integer(2));
         list.add(new Integer(1));
         list.add(new Integer(0));
 
         list.remove(list.indexOf(0));
 
         System.out.println(list);
     }
}
What will be the result of compiling and executing Test class?









Explanation
remove method of List interface is overloaded: remove(int) and remove(Object).

indexOf method accepts argument of Object type, in this case list.indexOf(0) => 0 is auto-boxed to Integer object so no issues with indexOf code. list.indexOf(0) returns 2 (index at which 0 is stored in the list). So list.remove(list.indexOf(0)); is converted to list.remove(2);



remove(int) version is matched, it's a direct match so compiler doesn't do auto-boxing in this case. list.remove(2) removes the element at index 2, which is 0. 



Hence in the output, you get [2, 1].

Question 42: Correct
Given code:

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         String [] arr = {"A", "B", "C", "D", "E"};
         for(/*INSERT*/) {
             System.out.print(arr[n]);
         }
     }
}
Which option, if used to replace /*INSERT*/, on execution will print ACE on to the console?









Explanation
You have to print element at index 0, 2 and 4, which means index must start with 0 and step expression should increment the index by 2.

Hence, int n = 0; n < arr.length; n += 2 is the correct answer.

Question 43: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         int [] arr = {2, 1, 0};
         for(int i : arr) {
             System.out.println(arr[i]);
         }
     }
}








Explanation
Inside enhanced for loop, System.out.println(arr[i]); is used instead of System.out.println(i); 

When loop executes 1st time, i stores the first array element, which is 2 but System.out.println statement prints arr[2] which is 0. Loop executes in this manner and prints 0 1 2 on to the console.

Question 44: Correct
Which of the following correctly defines class Printer?





Explanation
If package is used then it should be the first statement, but javadoc and developer comments are not considered as java statements so a class can have developer and javadoc comments before the package statement.

If import and package both are available, then correct order is package, import, class declaration.

Question 45: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         Double [] arr = new Double[2];
         System.out.println(arr[0] + arr[1]);
     }
}








Explanation
Array elements are initialized to their default values. arr is referring to an array of Double type, which is reference type and hence both the array elements are initialized to null.



To calculate arr[0] + arr[1], java runtime converts the expression to arr[0].doubleValue() + arr[1].doubleValue(). As arr[0] and arr[1] are null hence calling doubleValue() method throws NullPointerException.

Question 46: Correct
Which of these access modifiers can be used for a top level interface?









Explanation
A top level interface can be declared with either public or default modifiers.

public interface is accessible across all packages but interface declared with default modifier and be accessed in the defining package only.

Question 47: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         String str1 = new String("Core");
         String str2 = new String("CoRe");
         System.out.println(str1 = str2);
     }
}








Explanation
System.out.println(str1 = str2) has assignment(=) operator and not equality(==) operator.

After the assignment, str1 refers to "CoRe" and System.out.println prints "CoRe" to the console.

Question 48: Correct
For the class Test, which options, if used to replace /*INSERT*/, will print [5, 10] on to the console? Select 3 options.

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         /*INSERT*/
         arr[0] = 5;
         arr[1] = 10;
         System.out.println("[" + arr[0] + ", " + arr[1] + "]");
     }
}











Explanation
You can declare one-dimensional array by using either "short arr []" or "short [] arr". You can create an array object on the same line or next line.



"short arr [] = new short[2];" and "short [] arr; arr = new short[2];" both are correct. 



Array size cannot be specified at the time of declaration, so short [2] arr; gives compilation error. 



short [] arr = {}; => arr refers to a short array object of 0 size. so arr[0] = 5; and arr[1] = 10; will throw ArrayIndexOutOfBoundsException at runtime. 



short [] arr = new short[]{100, 100}; => arr refers to a short array object of size 2 and both array elements have value 100. arr[0] = 5; replaces 1st element value with 5 and arr[1] = 10; replaces 2nd element value with 10. So this is also a correct option. 



short [] arr = new short[2]{100, 100}; => Array's size can't be specified, if you use {} to assign values to array elements.

Question 49: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         double [] arr = new int[2]; //Line 3
         System.out.println(arr[0]); //Line 4
     }
}








Explanation
int variable can easily be assigned to double type but double [] and int [] are not compatible. In fact, both are siblings and can't be assigned to each other, so Line 3 causes compilation failure.
Question 50: Correct
Consider below code: 

public class Test {
     static {
         System.out.println(1/0);
     }
 
     public static void main(String[] args) {
         System.out.println("HELLO");
     }
}
On execution, does Test class print "HELLO" on to the console?





Explanation
To invoke the special main method, JVM loads the class in the memory. At that time, static initializer block is invoked. 1/0 throws a RuntimeException and as a result static initializer block throws an instance of java.lang.ExceptionInInitializerError.
Question 51: Correct
For the given code snippet:

List<String> list = new /*INSERT*/(); 

Which of the following options, if used to replace /*INSERT*/, compiles successfully?









Explanation
List is an interface so its instance can't be created using new keyword. List<String> and List<> will cause compilation failure.

ArrayList implements List interface, so it can be it can be used to replace /*INSERT*/. List<String> list = new ArrayList<String>(); compiles successfully.



Starting with JDK 7, Java allows to not specify type while initializing the ArrayList. Type is inferred from the left side of the statement.



So List<String> list = new ArrayList<>(); is a valid syntax starting with JDK 7.

Question 52: Correct
Consider code of Test.java file:

package com.udayan.oca;
 
import java.util.ArrayList;
import java.util.List;
 
public class Test {
     public static void main(String[] args) {
         List<Character> list = new ArrayList<>();
         list.add(0, 'V');
         list.add('T');
         list.add(1, 'E');
         list.add(3, 'O');
 
         if(list.contains('O')) {
             list.remove('O');
         }
 
         for(char ch : list) {
             System.out.print(ch);
         }
     }
}
What will be the result of compiling and executing Test class?













Explanation
list.add(0, 'V'); => char 'V' is converted to Character object and stored as the first element in the list. list --> [V]. 

list.add('T'); => char 'T' is auto-boxed to Character object and stored at the end of the list. list --> [V,T]. 

list.add(1, 'E'); => char 'E' is auto-boxed to Character object and inserted at index 1 of the list, this shifts T to the right. list --> [V,E,T]. 

list.add(3, 'O'); => char 'O' is auto-boxed to Character object and added at index 3 of the list. list --> [V,E,T,O].

list.contains('O') => char 'O' is auto-boxed to Character object and as Character class overrides equals(String) method this expression returns true. Control goes inside if-block and executes: list.remove('O');.



remove method is overloaded: remove(int) and remove(Object). char can be easily assigned to int so compiler tags remove(int) method. list.remove(<ASCCI value of 'O'>); ASCCI value of 'A' is 65 (this everybody knows) so ASCII value of 'O' will be more than 65.



list.remove('O') throws runtime exception, as it tries to remove an item from the index greater than 65 but allowed index is 0 to 3 only.

Question 53: Correct
A bank's swift code is generally of 11 characters and used in international money transfers. 
An example of swift code: ICICINBBRT4
ICIC: First 4 letters for bank code
IN: Next 2 letters for Country code
BB: Next 2 letters for Location code
RT4: Next 3 letters for Branch code

Which of the following code correctly extracts country code from the swift code referred by String reference variable swiftCode?









Explanation
substring(int beginIndex, int endIndex) is used to extract the substring. The substring begins at "beginIndex" and extends till "endIndex - 1". 

Country code information is stored at index 4 and 5, so the correct substring method to extract country code is: swiftCode.substring(4, 6);

Question 54: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         StringBuilder sb = new StringBuilder("Java");
         String s1 = sb.toString();
         String s2 = sb.toString();
 
         System.out.println(s1 == s2);
     }
}








Explanation
toString() method defined in StringBuilder class doesn't use String literal rather uses the constructor of String class to create the instance of String class.



So both s1 and s2 refer to different String instances even though their contents are same. s1 == s2 returns false.

Question 55: Correct
Consider below code:

//Test.java
package com.udayan.oca;
 
public class Test {
    public static void main(String[] args) {
        String s1 = "OCAJP";
        String s2 = "OCAJP" + "";
        System.out.println(s1 == s2);
    }
}
What will be the result of compiling and executing Test class?









Explanation
Please note that Strings computed by concatenation at compile time, will be referred by String Pool during execution. Compile time String concatenation happens when both of the operands are compile time constants, such as literal, final variable etc.



For the statement, String s2 = "OCAJP" + "";, `"OCAJP" + ""` is a constant expression as both the operands "OCAJP" and "" are String literals, which means the expression `"OCAJP" + ""` is computed at compile-time and results in String literal "OCAJP".

So, during compilation, Java compiler translates the statement

String s2 = "OCAJP" + "";

to

String s2 = "OCAJP";

As "OCAJP" is a String literal, hence at runtime it will be referred by String Pool.



When Test class is executed,

s1 refers to "OCAJP" (String Pool object).

s2 also refers to same String pool object "OCAJP".

s1 and s2 both refer to the same String object and that is why s1 == s2 returns true.



Please note that Strings computed by concatenation at run time (if the resultant expression is not constant expression) are newly created and therefore distinct.

For below code snippet:

String s1 = "OCAJP";
String s2 = s1 + "";
System.out.println(s1 == s2);
Output is false, as s1 is a variable and `s1 + ""` is not a constant expression, therefore this expression is computed only at runtime and a new non-pool String object is created.

Question 56: Correct
Consider below code: 

//Test.java
package com.udayan.oca;
 
import java.util.ArrayList;
import java.util.List;
 
class Student {
     private String name;
     private int age;
 
     Student(String name, int age) {
         this.name = name;
         this.age = age;
     }
 
     public String toString() {
         return "Student[" + name + ", " + age + "]";
     }
}
 
public class Test {
     public static void main(String[] args) {
         List<Student> students = new ArrayList<>();
         students.add(new Student("James", 25));
         students.add(new Student("James", 27));
         students.add(new Student("James", 25));
         students.add(new Student("James", 25));
 
         students.remove(new Student("James", 25));
 
         for(Student stud : students) {
             System.out.println(stud);
         }
     }
}
What will be the result of compiling and executing Test class?









Explanation
Before you answer this, you must know that there are 5 different Student object created in the memory (4 at the time of adding to the list and 1 at the time of removing from the list). This means these 5 Student objects will be stored at different memory addresses.



remove(Object) method removes the first occurrence of matching object and equals(Object) method decides whether 2 objects are equal or not. equals(Object) method defined in Object class uses == operator to check the equality and in this case as 5 Student objects are stored at different memory location, hence not equal.



Nothing is removed from the students list, all the 4 Student objects are printed in the insertion order.

Question 57: Correct
Consider below code: 

//Test.java
package com.udayan.oca;
 
import java.time.LocalDate;
import java.time.LocalTime;
 
public class Test {
     public static void main(String [] args) {
         LocalDate date = LocalDate.parse("1947-08-14");
         LocalTime time = LocalTime.MAX;
         System.out.println(date.atTime(time));
     }
}
What will be the result of compiling and executing Test class?









Explanation
LocalTime.MIN --> {00:00}, LocalTime.MAX --> {23:59:59.999999999}, LocalTime.MIDNIGHT --> {00:00}, LocalTime.NOON --> {12:00}. 



date.atTime(LocalTime) method creates a LocalDateTime instance by combining date and time parts.



toString() method of LocalDateTime class prints the date and time parts separated by T in upper case.

Question 58: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         short [] args = new short[]{50, 50};
         args[0] = 5;
         args[1] = 10;
         System.out.println("[" + args[0] + ", " + args[1] + "]");
     }
}








Explanation
main method's parameter variable name is "args" and it is a local to main method.

So, same name "args" can't be used directly within the curly brackets of main method.

short [] args = new short[]{50, 50}; gives compilation error for using same name for local variable.

Question 59: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         m1(); //Line 3
     }
 
     private static void m1() throws Exception { //Line 6
         System.out.println("NOT THROWING ANY EXCEPTION"); //Line 7
     }
}








Explanation
If a method declares to throw Exception or its sub-type other than RuntimeException types, then calling method should follow handle or declare rule. In this case, as method m1() declares to throw Exception, so main method should either declare the same exception or its super type in its throws clause OR m1(); should be surrounded by try-catch block.



Line 3 in this case causes compilation error.

Question 60: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     char c;
     double d;
     float f;
     public static void main(String[] args) {
         Test obj = new Test();
         System.out.println(">" + obj.c);
         System.out.println(">" + obj.d);
         System.out.println(">" + obj.f);
     }
}




Explanation
primitive type instance variables are initialized to respective zeros (byte: 0, short: 0, int: 0, long: 0L, float: 0.0f, double: 0.0, boolean: false, char: \u0000).

When printed on the console; byte, short, int & long prints 0, float & double print 0.0, boolean prints false and char prints nothing or non-printable character (white space). 

Reference type instance variables are initialized to null.

Question 61: Correct
Consider below code: 

//Test.java
package com.udayan.oca;
 
import java.util.ArrayList;
import java.util.List;
 
public class Test {
     public static void main(String[] args) {
         List<String> list1 = new ArrayList<>();
         list1.add("A");
         list1.add("D");
 
         List<String> list2 = new ArrayList<>();
         list2.add("B");
         list2.add("C");
 
         list1.addAll(1, list2);
 
         System.out.println(list1);
     }
}
What will be the result of compiling and executing Test class?









Explanation
list1 --> [A, D], 

list2 --> [B, C], 

list1.addAll(1, list2); is almost equal to list1.add(1, [B, C]); => Inserts B at index 1, C takes index 2 and D is moved to index 3. list1 --> [A, B, C, D]

Question 62: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         System.out.println("Output is: " + 10 != 5);
     }
}








Explanation
Binary plus (+) has got higher precedence than != operator. Let us group the expression. 

"Output is: " + 10 != 5 

= ("Output is: " + 10) != 5 

[!= is binary operator, so we have to evaluate the left side first. + operator behaves as concatenation operator.] 

= "Output is: 10" != 5 

Left side of above expression is String, and right side is int. But String can't be compared to int, hence compilation error. 

Question 63: Correct
Consider below code: 

//Test.java
package com.udayan.oca;
 
import java.util.ArrayList;
 
class Counter {
     int count;
     Counter(int count) {
         this.count = count;
     }
 
     public String toString() {
         return "Counter-" + count;
     }
}
 
public class Test {
     public static void main(String[] args) {
         ArrayList<Counter> original = new ArrayList<>();
         original.add(new Counter(10));
 
         ArrayList<Counter> cloned = (ArrayList<Counter>) original.clone();
         cloned.get(0).count = 5;
 
         System.out.println(original);
     }
}
What will be the result of compiling and executing Test class?









Explanation

Let's see what is happening during execution:

main(String [] args) method goes on to the top of the STACK.

1. ArrayList<Counter> original = new ArrayList<>(); => It creates an ArrayList object [suppose at memory location 15EE00] and variable 'original' refers to it.

2. original.add(new Counter(10)); => It creates a Counter object [suppose at memory location 25AF06] and adds it as a first element of the ArrayList. This means element at 0th index of the ArrayList instance refers to Counter object at the memory location 25AF06.

3. ArrayList<Counter> cloned = (ArrayList<Counter>) original.clone(); => original.clone() creates a new array list object, [suppose at memory location 45BA12] and then it will copy the contents of the ArrayList object stored at [15EE00]. So, cloned contains memory address of the same Counter object.

In this case, original != cloned, but original.get(0) == cloned.get(0). This means both the array lists are created at different memory location but refer to same Counter object. 

4. cloned.get(0).count = 5; => cloned.get(0) returns the Counter object stored at the memory location 25AF06 and .count = 5 means change the value of count variable of the Counter object (stored at memory location 25AF06) to 5. 

5. System.out.println(original); Prints the element of ArrayList original, which is: {25AF06} and toString() method prints: [Counter-5] as Counter object referred by [25AF06] is [Counter object (5)].

Question 64: Correct
Consider below code: 

//Test.java
package com.udayan.oca;
 
import java.time.LocalDate;
 
class MyLocalDate extends LocalDate {
     @Override
     public String toString() {
         return super.getDayOfMonth() + "-" + super.getMonthValue() + 
            "-" +  super.getYear();
     }
}
 
public class Test {
     public static void main(String [] args) {
         MyLocalDate date = LocalDate.parse("1980-03-16");
         System.out.println(date);
     }
}
What will be the result of compiling and executing Test class?











Explanation
LocalDate is a final class so cannot be extended.
Question 65: Correct
Which of the following is not a valid array declaration?









Explanation
1st array dimension must be specified at the time of declaration. new int[][8]; gives compilation error as 1st dimension is not specified.
Question 66: Correct
For the class Test, which options, if used to replace /*INSERT*/, will print "Lucky no. 7" on to the console? Select 3 options.

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         /*INSERT*/
         switch(var) {
             case 7:
                 System.out.println("Lucky no. 7");
                 break;
             default:
                 System.out.println("DEFAULT");
         }
     }
}










Explanation
switch can accept primitive types: byte, short, int, char; wrapper types: Byte, Short, Integer, Character; String and enums.

In this case, all are valid values but only 3 executes "case 7:". case is comparing integer value 7.

NOTE: character seven, '7' is different from integer value seven, 7. So "char var = '7';" and "Character var = '7';" will print DEFAULT on to the console.

Question 67: Correct
Consider below code:

//Test.java
package com.udayan.oca;
 
public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(100);
        System.out.println(sb.length() + ":" + sb.toString().length());
    }
}
What will be the result of compiling and executing Test class?











Explanation
`new StringBuilder(100);` creates a StringBuilder instance, whose internal char array's length is 100 but length() method of StringBuilder object returns the number of characters stored in the internal array and in this case it is 0. So, `sb.length()` returns 0.

sb.toString() is the String representation of StringBuilder instance and in this case as there are no characters inside the StringBuilder object, hence sb.toString() returns an empty String "", so `sb.toString().length()` also returns 0.

Output is 0:0.

Question 68: Correct
Which of the following is a checked Exception?









Explanation
ClassCastException extends RuntimeException (unchecked exception),

FileNotFoundException extends IOException, IOException extends Exception (checked exception),

ExceptionInInitializerError is from Error family and is thrown by an static initializer block,

RuntimeException and all its sub classes are unchecked exceptions.

Question 69: Correct
What will be the result of compiling and executing Test class?

package com.udayan.oca;
 
public class Test {
     public static void main(String[] args) {
         double price = 90000;
         String model;
         if(price > 100000) {
             model = "Tesla Model X";
         } else if(price <= 100000) {
             model = "Tesla Model S";
         }
           System.out.println(model);
     }
}








Explanation
In this case "if - else if" block is used and not "if - else" block.



90000 is assigned to variable 'price' but you can assign parameter value or call some method returning double value, such as:

'double price = currentTemp();'.



In these cases compiler will not know the exact value until runtime, hence Java Compiler is not sure which boolean expression will be evaluated to true and so variable model may not be initialized.



Usage of LOCAL variable, 'model' without initialization gives compilation error. Hence, System.out.println(model); gives compilation error.

Question 70: Correct
Consider below code: 

//Test.java
package com.udayan.oca;
 
import java.time.LocalDateTime;
 
public class Test {
     public static void main(String [] args) {
         LocalDateTime obj = LocalDateTime.now();
         System.out.println(obj.getSecond());
     }
}
Which of the following statement is correct?









Explanation
LocalDateTime stores both date and time parts. LocalDateTime.now(); retrieves the current date and time from the system clock. obj.getSecond() can return any value between 0 and 59.
