package com.vermeg.bookstoremvc.dao.entity;



import com.vermeg.bookstoremvc.constant.RoleEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "pasword")
	private String password;

	@Enumerated(EnumType.STRING)
	private RoleEnum role;

	@OneToMany(mappedBy = "user")
	private List<Order> orders;

	
}
