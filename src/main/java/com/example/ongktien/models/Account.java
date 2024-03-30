package com.example.ongktien.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@AllArgsConstructor@Getter@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountid;
    private String accountname;
    private String address;
    private String pass;
    @Override
    public String toString() {
        return "Account{" +
                "accountid=" + accountid +
                ", accountname='" + accountname + '\'' +
                ", address='" + address + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

}
