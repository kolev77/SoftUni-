package entities;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    private Long room_number;
    private RoomType roomType;
    private BedType bedType;
    private Integer rate;
    private RoomStatus roomStatus;
    private String notes;

    public Room() {
    }

    public Room(RoomType roomType, BedType bedType, Integer rate, RoomStatus roomStatus) {
        this.roomType = roomType;
        this.bedType = bedType;
        this.rate = rate;
        this.roomStatus = roomStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getRoom_number() {
        return room_number;
    }

    public void setRoom_number(Long room_number) {
        this.room_number = room_number;
    }

    @ManyToOne
    @JoinColumn(name = "room_type_id",referencedColumnName = "id")
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @ManyToOne
    @JoinColumn(name = "bed_type_id",referencedColumnName = "id")
    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @ManyToOne
    @JoinColumn(name = "room_status_id",referencedColumnName = "id")
    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
