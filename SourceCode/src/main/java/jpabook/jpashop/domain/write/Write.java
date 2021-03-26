package jpabook.jpashop.domain.write;

import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
@Getter @Setter
@DiscriminatorColumn(name = "write")
public class Write {

    @Id
    @GeneratedValue
    @Column(name = "write_id")
    private Long Id;

    private String title;

    private String content;

    private Date regDate;

    private File attach;


}
