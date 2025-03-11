0. Papers to read: https://cs.nyu.edu/~anirudh/CSCI-GA.2620-001/papers/aimd.pdf and https://cs.nyu.edu/~anirudh/CSCI-GA.2620-001/papers/bbr.pdf
<!-- 1. Why does the congestion avoidance and control paper use an additive increase and multiplicative decrease policy? What would happen if we used a different combination: additive decrease and multiplicative increase, for instance?
Ans: 1) Congestion Avoidance and Control paper uses AIMD so as to get to a stable and fair usage of bandwidth.
The use of Additive Increase is done to reach a good enough level of bandwidth while keeping a check on overshooting with the help of Multiplicative descrease.
Multiplicative Decrease is something that prevents congestion collapse by immediately reducing the sending rate. Wi​=dWi−1​,d&lt;1
This ensures that when congestion occurs (detected via timeouts or packet loss), TCP backs off quickly to avoid overwhelming the network.

If we use something like additive decrease and multiplicative increase, we would increase the bandwidth very quickly and it would quickly overload the network, leading to frequent congestion collapse. The Additive decrease won't be able to handle this quick overloading and increased congestion collapse. Thus we can conclude that anything apart from AIMD won't work in such cases.





2. Why does the BBR paper use a windowed minimum for estimating RTT?
Ans:&nbsp; The BBR (Bottleneck Bandwidth and Round-trip propagation time) paper uses a windowed minimum for estimating RTT (Round Trip Time) to ensure that the congestion control algorithm accurately identifies the propagation delay rather than mistakenly incorporating queuing delays.
a) By using a windowed minimum, BBR avoids falsely treating increased RTT due to buffering as an affecting condition.
b) windowed minimum RTT serves as the baseline (RTprop), and BBR ensures that its congestion control actions do not increase latency.

3. Why does the BBR paper use a windowed maximum for estimating Bottleneck Bandwidth?
4. What would happen if you ran BBR or the algorithm from "Congestion Avoidance and Control" on a wireless link that randomly loses packets (as opposed to dropping only packets when a buffer overflows)? -->