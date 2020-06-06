// Program java untuk menunjukkan implementasinya dari hash map
import java.util.ArrayList;
import java.util.Collections;  


// Kelas untuk mewakili seluruh tabel hash
public class Map<K, V> 
{ 
	// bucketArray untuk menyimpan rantai hash
	private ArrayList<HashNode<K, V>> bucketArray; 

	// Kapasitas saat ini dari array list
	private int numBuckets; 

	// ukuran dari array list 
	private int size; 

	// Constructor (Menginisialisasi kapasitas, ukuran, dan rantai kosong)
	public Map() 
	{ 
		bucketArray = new ArrayList<>(); 
		numBuckets = 10; 
		size = 0; 

		// membuat rantai kosong
		for (int i = 0; i < numBuckets; i++) 
			bucketArray.add(null); 
	} 

	public int size() { return size; } 
	public boolean isEmpty() { return size() == 0; } 

	// mengimplementasikan fungsi hash untuk menemukan indeks
	private int getBucketIndex(K key) 
	{ 
		int hashCode = key.hashCode(); 
		int index = hashCode % numBuckets; 
		return Math.abs(index); 
	} 

	// Method  untuk menghapus kunci yang diberikan
	public V remove(K key) 
	{ 
		// menerapkan fungsi hash untuk menemukan indeks untuk kunci yang diberikan
		int bucketIndex = getBucketIndex(key); 

		// mendapat kepala rantai
		HashNode<K, V> head = bucketArray.get(bucketIndex); 

		// Search for key in its chain 
		HashNode<K, V> prev = null; 
		while (head != null) 
		{ 
			// If Key found 
			if (head.key.equals(key)) 
				break; 

			// Else keep moving in chain 
			prev = head; 
			head = head.next; 
		} 

		// If key was not there 
		if (head == null) 
			return null; 

		// Reduce size 
		size--; 

		// Remove key 
		if (prev != null) 
			prev.next = head.next; 
		else
			bucketArray.set(bucketIndex, head.next); 

		return head.value; 
	}

	// Returns value for a key 
	public V get(K key) 
	{ 
		// Find head of chain for given key 
		int bucketIndex = getBucketIndex(key); 
		HashNode<K, V> head = bucketArray.get(bucketIndex); 

		// Search key in chain 
		while (head != null) 
		{ 
			if (head.key.equals(key)) 
				return head.value; 
			head = head.next; 
		} 

		// If key not found 
		return null; 
	} 

	// Adds a key value pair to hash 
	public void add(K key, V value) 
	{ 
		// Find head of chain for given key 
		int bucketIndex = getBucketIndex(key); 
		HashNode<K, V> head = bucketArray.get(bucketIndex); 

		// Check if key is already present 
		while (head != null) 
		{ 
			if (head.key.equals(key)) 
			{ 
				head.value = value; 
				return; 
			} 
			head = head.next; 
		} 

		// Insert key in chain 
		size++; 
		head = bucketArray.get(bucketIndex); 
		HashNode<K, V> newNode = new HashNode<K, V>(key, value); 
		newNode.next = head; 
		bucketArray.set(bucketIndex, newNode); 

		// If load factor goes beyond threshold, then 
		// double hash table size 
		if ((1.0*size)/numBuckets >= 0.7) 
		{ 
			ArrayList<HashNode<K, V>> temp = bucketArray; 
			bucketArray = new ArrayList<>(); 
			numBuckets = 2 * numBuckets; 
			size = 0; 
			for (int i = 0; i < numBuckets; i++) 
				bucketArray.add(null); 

			for (HashNode<K, V> headNode : temp) 
			{ 
				while (headNode != null) 
				{ 
					add(headNode.key, headNode.value); 
					headNode = headNode.next; 
				} 
			} 
		} 
	} 
} 
