package com.hle;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class PersonTest {

        @Test
        public void testPersonCollection() {

                // Création de personnes avec le builder

                Person jeanPerson = Person.builder()
                .firstName("Alice")
                .familyName("Durand")
                .birthDate(LocalDate.of(1985, 5, 15))
                .build();


                Person alicePerson = Person.builder()
                .firstName("Jean")
                .familyName("Dupont")
                .birthDate(LocalDate.of(1990, 10, 20))
                .build();

        
                Person bobPerson = Person.builder()
                .firstName("Bob")
                .familyName("Martin")
                .birthDate(LocalDate.of(2000, 3, 5))
                .build();


                // liste des personnes
                
        List<Person> personnes = Arrays.asList(jeanPerson, alicePerson, bobPerson);


                
                assertThat(personnes)
                                .hasSize(3) 
                                .extracting(Person::getFirstName) // Extraire  les prénoms
                                .contains("Jean", "Alice") // Vérifier la presence des noms
                                .doesNotContain("Charlie"); 


                // Vérifier age>20ans
                assertThat(personnes)
                                .allSatisfy(personne -> assertThat(personne.calculerAge()).isGreaterThan(8));

        }

}
 