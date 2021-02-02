package com.example.eventlistmvvm;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eventlistmvvm.roomdb.Event;

import java.util.List;

public class EventListViewModel extends ViewModel {
    // TODO: Complete the VM class
    // Make the MutableLiveData a singleton
    private MutableLiveData<List<Event>> eventsData;
    private EventRepository repo;

    public void init(Context context) {
        if (eventsData == null) {
            eventsData = new MutableLiveData<>();
        }
        repo = EventRepository.getInstance(context);
        eventsData.setValue(repo.getEvents());
    }

    public MutableLiveData<List<Event>> getEvents() {
        eventsData.setValue(repo.getEvents());
        return eventsData;
    }
}
