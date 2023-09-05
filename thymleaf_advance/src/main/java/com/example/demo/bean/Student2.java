package com.example.demo.bean;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {

    @NotBlank(message = "Khong de trong email")
            @Email(message = "khong dun ding dang email")
    String email;
    @NotBlank(message = "khong den trong ho va tten")
    String fullName;
    @NotNull(message = "khong de trong diem")
    @PositiveOrZero(message = "diem phai lon hon hoac bang 0")
    @Max(value = 10,message = "diem phai nho hon hoac bang 10")
    Double marks;
    @NotNull(message = "chon gioi tinh")
    Boolean gender;
    @NotBlank(message = "con quoc tich")
    String country;
}
