package collections;

import java.util.*;

public class MapUtilDemo {

	private Map<Integer, String> map = new HashMap<>();

	public MapUtilDemo() {
		initPut();
	}

	/**
	 * ʹ�ø��º��map����putIfAbsent
	 */
	private void initPut() {
		// putIfAbsentΪMap�ӿ���������һ��Ĭ�Ϸ���
		/**
		 * <code>
		          default V putIfAbsent(K key, V value) {
		            V v = get(key);
		            if (v == null) {
		                v = put(key, value);
		            }
		
		            return v;
		          }
		          </code>
		 */
		// ���map���ж�ӦKӳ���V�Ҳ�Ϊnull��ֱ�ӷ���;����ִ��put
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "value " + i);
		}

		// ������һ��nullԪ��
		map.putIfAbsent(10, null);
		// �滻null
		map.putIfAbsent(10, "value 10");
		// ��ΪK-10��ӳ���Ҳ�Ϊnull�����V-value11
		map.putIfAbsent(10, "value 11");
	}

	/**
	 * ʹ�ø��º��map����for-each
	 */
	public void forEach() {
		// default void forEach(BiConsumer<? super K, ? super V> action)
		// Map�ӿ���������Ĭ�Ϸ���

		// @FunctionalInterface public interface BiConsumer<T, U> {void accept(T
		// t, U u);
		map.forEach((id, val) -> System.out.println(val));
	}

	/**
	 * ʹ�ø��º��map����compute����->��ӳ��
	 */
	public void compute() {
		// default V computeIfPresent(K key,BiFunction<? super K, ? super V, ?
		// extends V> remappingFunction)

		// Map�ӿ���������Ĭ�Ϸ���

		// @FunctionalInterface public interface BiFunction<T, U, R> {R apply(T
		// t, U u);
		// --> V apply(K k,V v)

		// ifPresent���ж�key��Ӧ��v�Ƿ���null������null�Ż�compute->����ֱ�ӷ���null

		// ����:��K-3ӳ���value->compute->"value3" + 3 = value33
		map.computeIfPresent(3, (key, val) -> val + key);
		System.out.println(map.get(3));

		// ����:���ｫK-3ӳ���value������ӳ��->null
		// �÷���Դ��ʵ�ֻ��ж����newValueΪnull���ִ��remove(key)����,���Ƴ�key
		map.computeIfPresent(9, (key, val) -> null);
		// ������Ľ����еõ������Ϊfalse,��Ϊ�Ѿ����Ƴ���
		System.out.println(map.containsKey(9));

		// default V computeIfAbsent(K key,Function<? super K, ? extends V>
		// mappingFunction)
		// ����:����ʵ���Ͽ������K-15ӳ���ֵΪnull,�������ڻ���Ϊnull,��ִ��ӳ��->���Ա�������(û��15��key)���÷����൱�ڲ���һ����ֵ
		map.computeIfAbsent(15, (key) -> "val" + key);
		System.out.println(map.containsKey(15));
		System.out.println(map.get(15));

		// ��ΪK-4ӳ���ֵ���ڣ�����ֱ�ӷ��أ���������ӳ��,���������Ȼ����value4
		map.computeIfAbsent(4, key -> "bam");
		System.out.println(map.get(4));
	}

	/**
	 * ʹ�ø��º��map����remove
	 */
	public void remove() {
		// default boolean remove(Object key, Object value) {
		// Map�ӿ���������Ĭ�Ϸ���

		// ��Դ��ʵ����
		// 1.��ǰkey��Ӧ��ֵ�ʹ���Ĳ�����һ��ʱ��ֱ�ӷ��أ��Ƴ�ʧ��(�õ���Objects.equals����)
		// 2.��ǰkey��Ӧ��ֵΪnull��!containsKey(key),�Ƴ�ʧ��(����ǰmap�и������������key_����Ϊ��һ������������key����keyӳ���ֵΪnull��)
		// ->����ִ���Ƴ�

		/**
		 * <code>
		 *  default boolean remove(Object key, Object value) {
		        Object curValue = get(key);
		        if (!Objects.equals(curValue, value) ||
		            (curValue == null && !containsKey(key))) {
		            return false;
		        }
		        remove(key);
		        return true;
		    }
		 * </code>
		 */
		map.remove(3, "value4");
		System.out.println(map.get(3));

		// key��vƥ��ʱ���Ƴ��ɹ�
		map.remove(3, "value33");
		System.out.println(map.get(3));
	}

	/**
	 * getOrDefault��һ�����õķ���
	 */
	public void getOrDefault() {
		// default V getOrDefault(Object key, V defaultValue) {
		// Map�ӿ���������Ĭ�Ϸ���

		/**
		 * <code>
		 * default V getOrDefault(Object key, V defaultValue) {
		    V v;
		    return (((v = get(key)) != null) || containsKey(key))
		        ? v
		        : defaultValue;
		    }
		 * </code>
		 */

		// Դ��ʵ��:
		// 1.�����Ӧ��key��value�Ҳ�Ϊnull����ֱ�ӷ���value;���Ϊnull�Ұ�����key���򷵻�null(��֮������Ҫ�и�key)
		// 2.���û�и�key������Ĭ��ֵ
		String retV = map.getOrDefault("20", "not found");
		System.out.println(retV);

		// ����һ��null
		map.putIfAbsent(30, null);
		// ���null
		System.out.println(map.get(30));
		// ���null
		System.out.println(map.getOrDefault(30, "value30"));
	}

	/**
	 * �ϲ�
	 */
	public void merge() {
		// default V merge(K key, V value,BiFunction<? super V, ? super V, ?
		// extends V> remappingFunction)

		// @FunctionalInterface public interface BiFunction<T, U, R> { R apply(T
		// t, U u);

		// mergeΪMap�ӿ�������Ĭ�Ϸ���

		/**
		 * <code>
		 default V merge(K key, V value,
		    BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		        Objects.requireNonNull(remappingFunction);
		        Objects.requireNonNull(value);
		        V oldValue = get(key);
		        V newValue = (oldValue == null) ? value :
		                   remappingFunction.apply(oldValue, value);
		        if(newValue == null) {
		            remove(key);
		        } else {
		            put(key, newValue);
		        }
		    return newValue;
		 }
		 * </code>
		 */

		// ��Դ��ʵ��:
		// 1.�ֱ������remappingFunction��value�Ƿ�Ϊnull(����Objects.requireNonNull).->Ϊnull���׳���ָ��
		// 2.�ж�oldValue�Ƿ�Ϊnull,���Ϊnull�򽫴����newValue��ֵ;���oldValue��Ϊnull��ִ��merge����
		// --->apply(oldValue, value)
		// 3.�ж�newValue->���Ϊnull��ִ���Ƴ�������ִ�в���

		// k-9��ֵ��ִ��compute������ʱ���Ѿ����Ƴ���->����oldValueΪnull->����newValueΪ����Ĳ���value9->ִ�в���
		// �����������Ϊvalue9
		String newValue1 = map.merge(9, "value9", (value, newValue) -> value.concat(newValue));
		System.out.println(newValue1);
		System.out.println(map.get(9));

		// k-9��ֵ�����Ѿ�Ϊvalue9�ˣ�����ִ��merge����->"value9".concat("concat")->newValueΪ"value9concat"
		// ִ�в��룬�����������Ϊvalue9concat
		String newValue2 = map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(newValue2);
		System.out.println(map.get(9));

		// k-8ֵ����Ϊvalue8->ִ��merge����->ֱ�ӷ���"NewMerge8"->newValueΪ"NewMerge8"
		// ִ��put->�����������"NewMerge8"
		map.merge(8, "merge", (value, newValue) -> "NewMerge8");
		System.out.println(map.get(8));
	}

	public static void main(String[] args) {
		MapUtilDemo mDemo = new MapUtilDemo();
		// mDemo.forEach();
		// mDemo.compute();
		// mDemo.remove();
		// mDemo.getOrDefault();
		mDemo.merge();
	}

}
