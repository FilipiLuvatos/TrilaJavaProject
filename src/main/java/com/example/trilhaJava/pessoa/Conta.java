package com.example.trilhaJava.pessoa;

import com.example.trilhaJava.enumeration.StatusConta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Conta")
@Entity(name = "conta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int nConta;
    private int docConta;
    private int saldo;

    @Enumerated(EnumType.STRING)
    private StatusConta status;
}
