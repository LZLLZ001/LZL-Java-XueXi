/*
相关介绍了解就行：
记得看图片
网络编程，就是在一定的协议下，实现两台计算机的通信的程序。

TCP/IP协议： 传输控制协议/因特网互联协议( Transmission Control Protocol/Internet Protocol)，
是Internet最基本、最广泛的协议。它定义了计算机如何连入因特网，以及数据如何在它们之间传输的标准。
它的内部包含一系列的用于处理数据通信的协议，并采用了4层的分层模型，每一层都呼叫它的下一层所提供的
协议来完成自己的需求



java.net 包中包含的类和接口，它们提供低层次的通信细节。我们可以直接使用这些类和接口，
来专注于网络程序开发，而不用考虑通信的细节，包中提供了两种常见的网络协议的支持：

TCP协议是面向连接的通信协议，即传输数据之前，在发送端和接收端建立逻辑连接(三次握手)，
然后再传输数据，它提供了两台计算机之间可靠无差错的数据传输。可以保证传输数据的安全，
所以应用十分广泛，例如下载文件、浏览网页等.


UDP协议是一个面向无连接的协议。传输数据时，不需要建立连接，不管对方端服务是否启动，直接将
数据、数据源和目的地都封装在数据包中，直接发送。每个数据包的大小限制在64k以内。它是不可靠
协议，因为无连接，所以传输速度快，但是容易丢失数据。日常应用中,例如视频会议、QQ聊天等。


网络编程三要素:协议、IP地址、端口号
    端口号：用两个字节表示的整数，它的取值范围是0~65535。其中，0~1023之间的端口号用于一些知名的网
            络服务和应用，普通的应用程序需要使用1024以上的端口号


下面的需要背
TCP通信的客户端:向服务器发送连接请求,给服务器发送数据,读取服务器回写的数据
    表示客户端的类:
        java.net.Socket:此类实现客户端套接字（也可以就叫“套接字”）。套接字是两台机器间通信的端点。
        套接字:包含了IP地址和端口号的网络单位

    构造方法:
        Socket(String host, int port) 创建一个流套接字并将其连接到指定主机上的指定端口号。
        参数:
            String host:服务器主机的名称/服务器的IP地址
            int port:服务器的端口号

    成员方法:
        OutputStream getOutputStream() 返回此套接字的输出流。
        InputStream getInputStream() 返回此套接字的输入流。
        void close() 关闭此套接字。

    实现步骤:
        1.创建一个客户端对象Socket,构造方法绑定服务器的IP地址和端口号
        2.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象
        3.使用网络字节输出流OutputStream对象中的方法write,给服务器发送数据
        4.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
        5.使用网络字节输入流InputStream对象中的方法read,读取服务器回写的数据
        6.释放资源(Socket)
            Socket socket = new Socket("127.0.0.1",8888);
            OutputStream os = socket.getOutputStream();
            os.write("你好服务器".getBytes());
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            System.out.println(new String(bytes,0,len));
            socket.close();
     注意:
        1.客户端和服务器端进行交互,必须使用Socket中提供的网络流,不能使用自己创建的流对象
        2.当我们创建客户端对象Socket的时候,就会去请求服务器和服务器经过3次握手建立连接通路
            这时如果服务器没有启动,那么就会抛出异常ConnectException: Connection refused: connect
            如果服务器已经启动,那么就可以进行交互了




TCP通信的服务器端:接收客户端的请求,读取客户端发送的数据,给客户端回写数据
    表示服务器的类:
        java.net.ServerSocket:此类实现服务器套接字。

    构造方法:
        ServerSocket(int port) 创建绑定到特定端口的服务器套接字。

    服务器端必须明确一件事情,必须的知道是哪个客户端请求的服务器
    所以可以使用accept方法获取到请求的客户端对象Socket
    成员方法:
        Socket accept() 侦听并接受到此套接字的连接。

    服务器的实现步骤(与客户端的差不多):
        1.创建服务器ServerSocket对象和系统要指定的端口号
        2.使用ServerSocket对象中的方法accept,获取到请求的客户端对象Socket
        3.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
        4.使用网络字节输入流InputStream对象中的方法read,读取客户端发送的数据
        5.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象
        6.使用网络字节输出流OutputStream对象中的方法write,给客户端回写数据
        7.释放资源(Socket,ServerSocket)
            ServerSocket server = new ServerSocket(8888);
            Socket socket = server.accept();
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            System.out.println(new String(bytes,0,len));
            OutputStream os = socket.getOutputStream();
            os.write("收到谢谢".getBytes());
            socket.close();
            server.close();



void shutdownOutput() 禁用此套接字的输出流。
    解决:上传完文件,给服务器写一个结束标记
    对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列。
*/


public class 网络通信概述 {
}
