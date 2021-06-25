理论知识杂论：
            缓存一致性：也就是缓存中的数据应该与主存一致，当主存中的数据，例如X发生改变时候，
                        可以通过总线窥探（Bus Snooping） 标记为刷新，也就是缓存数据无效，需要重新从主存获取。
            缓存可见性：某一线程对变量X修改，其他线程可见，表示就是可见性，如果写入主存，当然就可以通过底层计算的
                        高速缓存一致性来达到。
            CAP： 一致性、可用性、分区容错


            无阻塞锁（lock-free）
                保障：没有保障
                类型：Happen-before
            乐观锁（optimistic lock）：
                保证：一致性
                类型：CompareAndSwap(CAS)
            消极锁 (pessimistic lock)
                保证：一致性
                类型：lock、mutex


            并发三概念：原子性、可见性、有序性。
            volatile保证 ： 可见性、有序性 修改必写主存，然后通知总线，缓存无效化、通过指令的内存屏障控制不可重排，保证有序性

1.ReentrantLock和synchronized都是独占锁,只允许线程互斥的访问临界区。但是实现上两者不同:synchronized加锁解锁的过程是隐式的,用户不用手动操作,
优点是操作简单，但显得不够灵活。一般并发场景使用synchronized的就够了；ReentrantLock需要手动加锁和解锁,且解锁的操作尽量要放在finally代码块中,保证线程正确释放锁。
ReentrantLock操作较为复杂，但是因为可以手动控制加锁和解锁过程,在复杂的并发场景中能派上用场。

2.ReentrantLock和synchronized都是可重入的。synchronized因为可重入因此可以放在被递归执行的方法上,且不用担心线程最后能否正确释放锁；
而ReentrantLock在重入时要却确保重复获取锁的次数必须和重复释放锁的次数一样，否则可能导致其他线程无法获得该锁。


公平锁是指当锁可用时,在锁上等待时间最长的线程将获得锁的使用权。而非公平锁则随机分配这种使用权。和synchronized一样，默认的ReentrantLock实现是非公平锁,因为相比公平锁，非公平锁性能更好。
当然公平锁能防止饥饿,某些情况下也很有用。在创建ReentrantLock的时候通过传进参数true创建公平锁,如果传入的是false或没传参数则创建的是非公平锁

公平锁保证：不会出现等待过长的饥饿情况，
非公平锁：性能更优。

 thread.interrupt();//是第一个线程中断

 ReentrantLock还给我们提供了获取锁限时等待的方法tryLock(),可以选择传入时间参数,表示等待指定的时间,
 无参则表示立即返回锁申请的结果:true表示获取锁成功,false表示获取锁失败。我们可以使用该方法配合失败重试机制来更好的解决死锁问题。

当使用synchronized实现锁时,阻塞在锁上的线程除非获得锁否则将一直等待下去，也就是说这种无限等待获取锁的行为无法被中断。
而ReentrantLock给我们提供了一个可以响应中断的获取锁的方法lockInterruptibly()。该方法可以用来解决死锁问题。


锁相关： https://www.cnblogs.com/takumicx/p/9338983.html
优质的博客



transient :
     被该字段修饰的，不参与序列化  java.io.Serializable       -- Synchronized synchronized Synchronized

