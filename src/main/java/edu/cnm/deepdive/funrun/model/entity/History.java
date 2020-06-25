package edu.cnm.deepdive.funrun.model.entity;


import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Source;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class History {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "history_id", nullable = false, updatable = false)
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date start;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date end;

  @ManyToOne(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "event_id", nullable = true)
  private Event event;

  @NonNull
  @Column(length = 4096, nullable = false)
  private int distance;

  public void setUser(User user) {
    this.user = user;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public Long getId() {
    return id;
  }

  public Date getStart() {
    return start;
  }

  public Date getEnd() {
    return end;
  }

  public User getUser() {
    return user;
  }

  public Event getEvent() {
    return event;
  }

  public int getDistance() {
    return distance;
  }
}

