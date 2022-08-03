package org.example;

import org.example.model.Person;

public class App 
{
    public static void main( String[] args )
    {
       Person person=new Person(1, "John Doe");
       System.out.println(person);
    }
}
