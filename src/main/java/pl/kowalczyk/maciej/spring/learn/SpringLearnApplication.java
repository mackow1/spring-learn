package pl.kowalczyk.maciej.spring.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

}

// TODO: 19.12.2023 Analogicznie do NoteController stworzyć AuthorController
// W nowym kontrolerze obsłużyć żądania protokołu http dla adresu url /authors
// Analogicznie do NoteRepository stworzyć AuthorRepository + test jednostkowy + springowy test jednostkowy


// TODO: 02.01.2024 Wygenerować aplikację springboot za pomocą start.spring.io
// Analogicznie dla aplikacji spring-learn utworzyć warstwy oraz testy dla nowo wygenerowanej aplikacji

// TODO: 05.01.2024 Stworzyć formularz html dla AuthorController analogicznie jak ApartmentController
// https://geek.justjoin.it/komunikacja-frontend-www-z-backend-w-javie/

// TODO: 09.01.2024 Dla wybranych modeli stworzyć Entity, repozytoria i testy

// TODO: 09.01.2024 Dokończyć metody CRUD dla apartment i author repository używając findById i deleteById + testy

// TODO: 12.01.2024 Dodać wszystko do git (branch: core-controller itp.)

// TODO: 12.01.2024 Zrobić refactor ApartmentService, wydzielić metodę do nowej class i dodać ModelMapper
// https://medium.com/@robindamisi/model-mapping-entities-to-dto-pojo-and-vise-versa-in-java-spring-boot-with-lombok-for-security-a34774ced8ff
// Spring validation https://spring.io/guides/gs/validating-form-input/

// TODO: 16.01.2024 Wyświetlić liste dla Author, Car. Dodać mappery i testy

// TODO: 26.01.2024 Zamienić na formularze thymeleaf Car i Author