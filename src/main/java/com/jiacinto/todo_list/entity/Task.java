@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be blank") // Nous nous assurons que le champ titre n'est ni 'null', ni vide et ne contient pas par exemple que des espaces
    private String title;

    private boolean completed;
    private LocalDate dueDate;
}