#Sender-Receiver Synchronization Problem

- The Sender is supposed to send a data packet to the Receiver.
- The Receiver cannot process the data packet until the Sender finishes sending it.
- Similarly, the Sender shouldn't attempt to send another packet unless the Receiver has already processed the previous packet.

##Thread lifecycle
![img.png](../../../../img.png)