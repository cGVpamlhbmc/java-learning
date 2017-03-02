package collections;

import java.util.*;

public class StreamUtilDemo {
	private List<String> sList = new ArrayList<String>();

	public StreamUtilDemo() {
		init();
	}

	private void init() {
		initStringList();
	}

	/**
	 * ��ʼ���ַ����б�
	 */
	private void initStringList() {
		sList.add("zzz1");
		sList.add("aaa2");
		sList.add("bbb2");
		sList.add("fff1");
		sList.add("fff2");
		sList.add("aaa1");
		sList.add("bbb1");
		sList.add("zzz2");
	}

	/**
	 * Filter����һ��predicate�ӿ����͵ı��������������������е�Ԫ�ؽ��й��ˡ��ò�����һ���м������
	 * ��������������ڷ��ؽ���Ļ������ٽ���������������
	 * ��forEach����ForEach����һ��function�ӿ����͵ı���������ִ�ж�ÿһ��Ԫ�صĲ���
	 * ��ForEach��һ����ֹ�������������������������ǲ����ٵ���������������
	 */
	public void useStreamFilter() {
		// stream()������Collection�ӿڵ�һ��Ĭ�Ϸ���
		// Stream<T> filter(Predicate<? super T>
		// predicate);filter����������һ��Predicate����ʽ�ӿڲ���������Stream�ӿ�
		// void forEach(Consumer<? super T> action);foreach����������һ��Consumer����ʽ�ӿ�
		// ����:���ַ��������й��˳����ַ�a��ͷ���ַ�����������ӡ���
		sList.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
	}

	/**
	 * Sorted��һ���м�������ܹ�����һ���Ź�������������ͼ���������е�Ԫ�ػ�Ĭ�ϰ�����Ȼ˳���������
	 * �������Լ�ָ��һ��Comparator�ӿ����ı��������.
	 * 
	 * <p>
	 * һ��Ҫ��ס��sortedֻ�Ǵ���һ���������������ͼ��������ı�ԭ��������Ԫ�ص�˳��ԭ��string�����е�Ԫ��˳����û�иı��
	 */
	public void useStreamSort() {
		// Stream<T> sorted();����Stream�ӿ�
		// ���⻹��һ�� Stream<T> sorted(Comparator<? super T>
		// comparator);��Comparator�ӿڵĲ���
		sList.stream().filter((s) -> s.startsWith("a")).sorted().forEach(System.out::println);
		System.out.println("#####");
		// ���ԭʼ����Ԫ�أ�sortedֻ�Ǵ���������ͼ����Ӱ��ԭ������˳��
		sList.stream().forEach(System.out::println);
	}

	/**
	 * map��һ��������������м������ͨ�������ķ��������ܹ����������е�ÿһ��Ԫ�ض�Ӧ������һ�������ϡ�
	 * ��������Ӿ���ʾ����ΰ�ÿ��string��ת���ɴ�д��string.
	 * ������ˣ��㻹���԰�ÿһ�ֶ���ӳ���Ϊ�������͡����ڴ����ͽ���������󣬾�������ͻ�Ҫ�ɴ��ݸ�map�ķ��ͷ�����������
	 */
	public void useStreamMap() {
		// <R> Stream<R> map(Function<? super T, ? extends R> mapper);
		// map��������ΪFunction����ʽ�ӿ�(R_String,T_String).

		// ����:������Ԫ��תΪ��д(ÿ��Ԫ��ӳ�䵽��д)->��������->�������
		// ��Ӱ��ԭ������
		sList.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
	}
	
	  /**
     * ƥ������ж��ֲ�ͬ�����ͣ����������ж�ĳһ�ֹ����Ƿ����������໥�Ǻϵġ����е�ƥ����������ս������ֻ����һ��boolean���͵Ľ��
     */
    public void useStreamMatch() {
        // boolean anyMatch(Predicate<? super T> predicate);����ΪPredicate����ʽ�ӿ�
        // ����:�������Ƿ�����һԪ��ƥ����'a'��ͷ
        boolean anyStartsWithA = sList.stream().anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);

        // boolean allMatch(Predicate<? super T> predicate);
        // ����:�������Ƿ�����Ԫ��ƥ����'a'��ͷ
        boolean allStartsWithA = sList.stream().allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);

        // boolean noneMatch(Predicate<? super T> predicate);
        // ����:�������Ƿ�û��Ԫ��ƥ����'d'��ͷ
        boolean nonStartsWithD = sList.stream().noneMatch((s) -> s.startsWith("d"));
        System.out.println(nonStartsWithD);
    }
    
    /**
     * Count��һ���ս���������������Ƿ���һ����ֵ��������ʶ��ǰ�������а�����Ԫ������
     */
    public void useStreamCount() {
        // long count();
        // ����:���ؼ�������'a'��ͷԪ�ص���Ŀ
        long startsWithACount = sList.stream().filter((s) -> s.startsWith("a")).count();
        System.out.println(startsWithACount);
        System.out.println(sList.stream().count());
    }
    
    /**
     * �ò�����һ���ս���������ܹ�ͨ��ĳһ����������Ԫ�ؽ��������������ò����Ľ�������һ��Optional�����ﷵ�ء�
     */
    public void useStreamReduce() {
        // Optional<T> reduce(BinaryOperator<T> accumulator);
        // @FunctionalInterface public interface BinaryOperator<T> extends
        // BiFunction<T,T,T> {

        // @FunctionalInterface public interface BiFunction<T, U, R> { R apply(T
        // t, U u);
		Optional<String> reduced = sList.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);

        // ����:����Ԫ�������->reduce(���� )->��Ԫ����#����->����Optional����(��get��������#ƴ�Ӻ��ֵ)
        reduced.ifPresent(System.out::println);
        System.out.println(reduced.get());
    }
    
    /**
     * ʹ�ò�����
     * <p>
     * ������������˳��ģ�Ҳ�����ǲ��еġ�˳�����ͨ�����߳�ִ�У������в�����ͨ�����߳�ִ��. ��ʹ�ò��������в������������Ч��
     */
    public static void useParallelStreams() {
        // ��ʼ��һ���ַ�������
        int max = 1000000;
        List<String> values = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // ʹ��˳��������

        long sequenceT0 = System.nanoTime();
        values.stream().sorted();
        long sequenceT1 = System.nanoTime();

        // ���:sequential sort took: 51921 ms.
        System.out.format("sequential sort took: %d ms.", sequenceT1 - sequenceT0).println();

        // ʹ�ò���������
        long parallelT0 = System.nanoTime();
        // default Stream<E> parallelStream() {
        // parallelStreamΪCollection�ӿڵ�һ��Ĭ�Ϸ���
        values.parallelStream().sorted();
        long parallelT1 = System.nanoTime();

        // ���:parallel sort took: 21432 ms.
        System.out.format("parallel sort took: %d ms.", parallelT1 - parallelT0).println();

        // ��������Կ����������������һ����
    }

	public static void main(String[] args) {
		StreamUtilDemo sDemo = new StreamUtilDemo();
//		sDemo.useStreamFilter();
//		System.out.println("----------");
//		sDemo.useStreamSort();
//		System.out.println("----------");
//		sDemo.useStreamMap();
//		System.out.println("----------");
//		sDemo.useStreamMatch();
//		System.out.println("----------");
//		sDemo.useStreamCount();
//		System.out.println("----------");
//		sDemo.useStreamReduce();
		
		useParallelStreams();
	}
}
