package procesos.inventario.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "firsName is required")
    @Size(max = 100, message = "firstName max 100 characters")
    private String firstName;
    @NotNull(message = "lastName is required")
    @Size(max = 100, message = "lastName max 100 characters")
    private String lastName;
    @OneToMany(mappedBy = "user")
    private List<Address> address;
    @NotNull(message = "email is required")
    @Size(min = 8, max = 30, message = "email is required")
    private String email;
    @NotNull(message = "phone is required")
    @Size(min = 1, max = 16, message = "phone min 1 and max 16 is characters")
    private String phone;
    @NotNull(message = "password is required")
    @Size(min = 5, max = 15, message = "password min 5 and max 15 charcaters")
    private String password;
    @NotNull(message = "documents is required")
    @Size(min = 6, max = 15, message = "document min 6 and max 15 characters")
    private String document;
}
