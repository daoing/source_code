package exHashmap_link.Arraylist;

import java.util.ArrayList;
import java.util.List;

public class ExtArrayListMap_Core<Key, Value> {
	
	//用ArrayList 结合  Entry 封装
	List<Entry<Key, Value>> tables = new ArrayList<Entry<Key, Value>>();
	
	public void put(Key key, Value value) {
		// 判断key是否已经重复
		exHashmap_link.Arraylist.Entry<Key, Value> existEntry = getEntry(key);
		if (existEntry != null) {
			existEntry.value = value;
			return;
		}
		Entry<Key, Value> entry = new Entry<Key, Value>(key, value);
		// 添加时利用原生list 中 的 add
		tables.add(entry);
	}
	
	public void remove(Key key) {
		exHashmap_link.Arraylist.Entry<Key, Value> existEntry = getEntry(key);
		if (existEntry != null) {
			tables.remove(existEntry);
		}
	}
	
	public Entry<Key, Value> getEntry(Key key) {
		for (Entry<Key, Value> entry : tables) {
			if (entry.key.equals(key)) {
				return entry;
			}
		}
		return null;
	}
	
	
	public Value get(Key key) {
		for (Entry<Key, Value> entry : tables) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}
}

//定义一个key 和 value 带泛型的类  
class Entry<Key, Value> {

	public Entry(Key key, Value value) {
		this.key = key;
		this.value = value;
	}

	Key key;
	Value value;
}
