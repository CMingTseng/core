package com.zipe.entity

import com.zipe.enum.ScheduleJobStatusEnum
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "schedule_job_log")
data class ScheduleJobLog(

    @Id
    @Column(name = "id")
    var id: Int = 0,

    @Column(name = "job_name", unique = true)
    var jobName: String = "",

    @Column(name = "job_description")
    var jobDescription: String = "",

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status: ScheduleJobStatusEnum? = null,

    @Column(name = "start_time")
    var startTime: LocalDateTime? = null,

    @Column(name = "end_time")
    var endTime: LocalDateTime? = null,

    @Column(name = "message")
    var message: String = ""

) : Serializable
