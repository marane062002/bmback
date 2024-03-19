package com.bmh.Models.medecinLegale;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class HistoriqueObstacel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nouveauStatut;
    @ManyToOne
    @JoinColumn(name = "obstacleDefuntsId")
    private ObstacleDefunts obstacleDefunts;
    @Column(name = "updated_at")
    private Date updatedAt;
    @PrePersist
    protected void onCreate() {
        updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNouveauStatut() {
        return nouveauStatut;
    }

    public void setNouveauStatut(String nouveauStatut) {
        this.nouveauStatut = nouveauStatut;
    }

    public ObstacleDefunts getObstacleDefunts() {
        return obstacleDefunts;
    }

    public void setObstacleDefunts(ObstacleDefunts obstacleDefunts) {
        this.obstacleDefunts = obstacleDefunts;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
