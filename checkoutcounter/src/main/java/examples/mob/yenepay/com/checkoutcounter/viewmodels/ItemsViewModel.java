package examples.mob.yenepay.com.checkoutcounter.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import examples.mob.yenepay.com.checkoutcounter.db.entity.ItemCategory;
import examples.mob.yenepay.com.checkoutcounter.db.entity.StoreItem;
import examples.mob.yenepay.com.checkoutcounter.store.StoreRepository;

public class ItemsViewModel extends AndroidViewModel {
    private StoreRepository mStoreRepo;
    private LiveData<List<StoreItem>> items;

    private LiveData<List<ItemCategory>> categories;

    public ItemsViewModel(@NonNull Application application) {
        super(application);
        mStoreRepo = StoreRepository.getInstance(application);
        categories = mStoreRepo.getAllCategories();
        items = mStoreRepo.getAllItems();
    }


    public LiveData<List<StoreItem>> getAllItems() {
//        if (items == null) {
//            items = new MutableLiveData<List<StoreItem>>();
//            loadItems();
//        }
        return items;
    }

    public LiveData<List<ItemCategory>> getAllCategories() {
//        if (items == null) {
//            items = new MutableLiveData<List<StoreItem>>();
//            loadItems();
//        }
        return categories;
    }

    private void loadItems() {
//        items.setValue(StoreManager.ITEMS);
        // Do an asynchronous operation to fetch users.
    }
}
