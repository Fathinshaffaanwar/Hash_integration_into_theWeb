public class HashNode<K, V> 
{ 
	K key; 
	V value; 

	// Referensi ke node berikutnya
	HashNode<K, V> next; 

	// Constructor 
	public HashNode(K key, V value) 
	{ 
		this.key = key; 
		this.value = value; 
	} 
} 