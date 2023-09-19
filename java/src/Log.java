
// 学习文章：https://mp.weixin.qq.com/s/MIBHh5NO0GvWBOVJ_Jzn2w
// 日志格式：timeStamp|threadName logLevel loggerName|sourceAppName,flowId,traceId,sceneCode,identityCode,loginUserId,scpCode,rpcId,isYace,ip||businessCode,isSuccess||parameters||returnResult||
public class Log {
    
    
    /**
     * 递归逆向打印堆栈及cause(即从最底层的异常开始往上打)
     * @param t 原始异常
     * @param causeDepth 需要递归打印的cause的最大深度
     * @param counter 当前打印的cause的深度计数器(这里必须用引用类型，如果用基本数据类型，你对计数器的修改只能对当前栈帧可见，但是这个计数器，又必须在所有栈帧中可见，所以只能用引用类型)
     * @param stackDepth 每一个异常栈的打印深度
     * @param sb 字符串构造器
     */
    public static void recursiveReversePrintStackCause(Throwable t, int causeDepth, ForwardCounter counter, int stackDepth, StringBuilder sb){
        if(t == null){
            return;
        }
        if (t.getCause() != null){
            recursiveReversePrintStackCause(t.getCause(), causeDepth, counter, stackDepth, sb);
        }
        if(counter.i++ < causeDepth){
            doPrintStack(t, stackDepth, sb);
        }
    }
    
    public static void doPrintStack(Throwable t, int stackDepth, StringBuilder sb){
        StackTraceElement[] stackTraceElements = t.getStackTrace();
        if(sb.lastIndexOf("\t") > -1){
            sb.deleteCharAt(sb.length()-1);
            sb.append("Caused: ");
        }
        sb.append(t.getClass().getName()).append(": ").append(t.getMessage()).append("\n\t");
        for(int i=0; i < stackDepth; ++i){
            if(i >= stackTraceElements.length){
                break;
            }
            StackTraceElement element = stackTraceElements[i];
            sb.append(element.getMethodName())
                    .append("#")
                    .append(element.getMethodName())
                    .append(":")
                    .append(element.getLineNumber())
                    .append("\n\t");
        }
    }
    
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try {
            testEx();
        } catch (Exception e) {
            e.printStackTrace();
            recursiveReversePrintStackCause(e, 3, new ForwardCounter(), 3, sb);
        }
        System.out.println(sb.toString());
    }
    
    public static void testEx() {
        try {
            testExw();
        } catch (Exception e) {
            throw new ArrayIndexOutOfBoundsException("xxx");
        }
    }
    
    public static void testExw() {
        throw new NullPointerException("xxx");
    }
    
    public static class ForwardCounter {
        public int i;
    }
}
