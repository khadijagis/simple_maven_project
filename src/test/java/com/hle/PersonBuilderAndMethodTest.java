package com.hle;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;



public class PersonBuilderAndMethodTest {

    @Test
    public void testPersonConstructorBuilder() {

        Person jamalPerson = Person.builder()
                .firstName("khadija")
                .familyName("L'kamel")
                .build(); // Utilisation du builder pour créer l'objet
        
        assertThat(jamalPerson).isNotNull();

        
        assertThat(jamalPerson.getFirstName()).isEqualTo("khadija");

    
        assertThat(jamalPerson.getFamilyName()).isEqualTo("L'kamel");




    }

}
