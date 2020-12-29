package fr.efrei.reagency.repository;

import java.util.Iterator;
import java.util.List;

import android.content.Context;

import androidx.room.Room;

import fr.efrei.reagency.bo.Property;
import fr.efrei.reagency.database.PropertyDatabase;

//This class implement the singleton pattern
public final class PropertyRepository {

    private static volatile PropertyRepository instance;

    // We accept the "out-of-order writes" case
    public static PropertyRepository getInstance(Context context) {
        if (instance == null) {
            synchronized (PropertyRepository.class) {
                if (instance == null) {
                    instance = new PropertyRepository(context);
                }
            }
        }

        return instance;
    }

    private final PropertyDatabase propertyDatabase;

    private PropertyRepository(Context context) {
        propertyDatabase = Room.databaseBuilder(context, PropertyDatabase.class, "property-database").allowMainThreadQueries().build();
    }

    public List<Property> getProperties() {
        return propertyDatabase.propertyDao().getProperties();
    }

    public List<Property> getPropertiesSearch(String searchCriteria) {
        List<Property> properties = propertyDatabase.propertyDao().getProperties();
        String[] parts = searchCriteria.split(";");
        for (int j = 0; j < properties.size(); j++)
        {
            for (int i = 0; i < parts.length; i++) {
                String[] parts2 = parts[i].split("=");
                switch (parts2[0]) {
                    case "propertyTypeHouse":
//                        if (property.propertyType.equals(parts2[1]))
                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
//                    case "":
//                        break;
                }
            }
        }
//        for (int i = 0; i < parts.length; i += 2) {
//            map.put(parts[i], parts[i + 1]);
//        }

        return properties;
    }

    public void deleteProperty(Property property) {
        propertyDatabase.propertyDao().deleteProperty(property);
    }

    public void addProperty(Property property) {
        propertyDatabase.propertyDao().addProperty(property);
    }

    public List<Property> sortPropertiesByIdDes() {
        return propertyDatabase.propertyDao().sortPropertiesByIdDes();
    }

    public List<Property> sortPropertiesByIdAsc() {
        return propertyDatabase.propertyDao().sortPropertiesByIdAsc();
    }

    public List<Property> sortPropertiesByHouse() {
        return propertyDatabase.propertyDao().sortPropertiesByHouse();
    }

    public List<Property> sortPropertiesByFlat() {
        return propertyDatabase.propertyDao().sortPropertiesByFlat();
    }

    public List<Property> sortPropertiesByOffice() {
        return propertyDatabase.propertyDao().sortPropertiesByOffice();
    }

    public List<Property> sortPropertiesByStudent() {
        return propertyDatabase.propertyDao().sortPropertiesByStudent();
    }

    public List<Property> sortPropertiesByPriceAsc() {
        return propertyDatabase.propertyDao().sortPropertiesByPriceAsc();
    }

    public List<Property> sortPropertiesByPriceDes() {
        return propertyDatabase.propertyDao().sortPropertiesByPriceDes();
    }

    public List<Property> sortPropertiesBySurfaceAsc() {
        return propertyDatabase.propertyDao().sortPropertiesBySurfaceAsc();
    }

    public List<Property> sortPropertiesBySurfaceDes() {
        return propertyDatabase.propertyDao().sortPropertiesBySurfaceDes();
    }

}
