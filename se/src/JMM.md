`JMM规定所有变量都存储在主内存，主内存是共享内存区域，所有线程都可以访问
  但线程对变量的操作（读取赋值等）必须在工作内存中进行，
  首先要将变量从主内存拷贝到自己的工作空间，
  然后对变量进行操作
  操作完成后将变量写回主内存
  不能直接操作主内存的变量。
  
     volatile