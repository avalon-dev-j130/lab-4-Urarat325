package ru.avalon.java.tcp;

import java.io.*;
import java.net.*;

/**
 * Упражнение на выработку базовых умений использования протокола TCP.
 *
 * @author Daniel Alpatov
 */
public final class TcpSender {

    public static void main(String[] args) throws IOException {
        // 1. Подготавливааем сообщение
        final String message = prepareMessage();
        // 2. Подготавливаем адрес
        final SocketAddress address = prepareAddress();
        // 3. Устанавливаем соединение
        Socket socket = connect(address);
        // 4. Отправляем сообщение
        send(socket, message);
        // 5. Закрываем соединеие
        socket.close();
    }

    /**
     * Возвращает объект сообщения.
     *
     * @return текстовое сообщение.
     */
    private static String prepareMessage() {
        /*
         * TODO Реализовать метод prepareMessage класса TcpSender
         */
        return "Hi";
    }

    /**
     * Возвращает адрес, на который будет выполнена отправка сообщения.
     *
     * @return экземпля типа {@link SocketAddress}
     */
    private static SocketAddress prepareAddress() throws UnknownHostException {
        /*
         * TODO Реализовать метод prepareAddress класса TcpSender
         */
        InetAddress add = InetAddress.getLocalHost();
        SocketAddress finalAddress = new InetSocketAddress(add, 7450);
        return finalAddress;
    }

    /**
     * Устанавливает соединение на указанный адрес и возвращает сокет
     * описывающий соединение.
     *
     * @param address адрес, на который будет выполено соединение.
     *
     * @return сокет, описывающий открытое соединеие.
     *
     * @throws IOException
     */
    private static Socket connect(SocketAddress address) throws IOException {
        /*
         * TODO Реализовать метод connect класса TcpSender
         */
        Socket result = new Socket();
        result.connect(address);
        return result;
    }

    /**
     * Выполняет отправку сообщения {@code message} на {@code socket}.
     *
     * @param socket соединение, через которое будет отправлено сообщение.
     * @param message сообщение
     *
     * @throws IOException
     */
    private static void send(Socket socket, String message) throws IOException {
        /*
         * TODO Реализовать метод send класса TcpSender
         */
        OutputStream st = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(st);
        writer.write(message + "\r");
        writer.flush();
        System.out.println(message);
    }
}
