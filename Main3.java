import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.Comparator;
public class Main3 {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.getAllThreadIds();
        ThreadInfo[] threadInfos = Arrays.stream(threadIds)
                .mapToObj(threadMXBean::getThreadInfo)
                .toArray(ThreadInfo[]::new);
        Arrays.sort(threadInfos, Comparator.comparingInt(ThreadInfo::getPriority)); // Сортируем массив ThreadInfo по приоритету по возрастанию
        for (ThreadInfo threadInfo : threadInfos) {
            String threadName = threadInfo.getThreadName();
            System.out.println("Имя процесса: " + threadName);
        }
    }
}