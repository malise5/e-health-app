package com.malise.app.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.malise.app.view.html.AnnoHtmlForm;
import com.malise.app.view.html.AnnoHtmlFormField;
import com.malise.app.view.html.AnnoTableHeader;
import com.malise.app.view.html.HtmlTable;

@Entity
@Table(name = "appointments")
@AnnoHtmlForm(label = "Appointment", url = "./appointment")
@HtmlTable(addUrl = "./appointment", deleteUrl = "./appointment?type=appointment&mode=remove&appointmentID=")
public class Appointment extends BaseEntity {

  @Column(name = "appointment_Date")
  @AnnoTableHeader(header = "Appointment Date")
  @AnnoHtmlFormField(label = "Appointment Date")
  private Date appointmentDate;

}
