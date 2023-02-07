package com.esther.activitytracker.payload;

import com.esther.activitytracker.model.User;
import com.esther.activitytracker.utility.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto {
    private String title;
    private String description;

    private Status status;

}
