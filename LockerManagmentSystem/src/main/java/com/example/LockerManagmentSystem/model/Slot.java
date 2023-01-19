package com.example.LockerManagmentSystem.model;

import com.example.LockerManagmentSystem.exception.SlotAlreadyOccupiedException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
@Getter
public class Slot {
    private final String slotId;
    private final Size size;
    private final Locker locker;
    private LockerItem currentLockerItem;
    private Date allocationDate;
    public Slot(String slotId, Size size, Locker locker) {
        this.slotId = slotId;
        this.size = size;
        this.locker = locker;
    }
    public  void allocatePackage(@NonNull final LockerItem newLockerItem)
    {
        if(this.currentLockerItem!=null)
        {
            throw new SlotAlreadyOccupiedException();
        }
        this.allocationDate=new Date();
        this.currentLockerItem=newLockerItem;
    }
    public void deallocateSlot()
    {
        this.currentLockerItem=null;
    }

    public boolean isAvailable()
    {
        return this.currentLockerItem==null;
    }

}
