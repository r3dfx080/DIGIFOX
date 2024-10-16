
# Why DigiFox?
 - Designed by specialist for specialists
 - "0 IQ" usage with intuitive UI
 - Fast navigation and orders tracking
 - Extensive statistics and metrics
 
# Designed by specialist for specialists

This is my personal app, created specifically for tracking and managing orders for digitization. Only essential modules, no overengineering! 

# Intuitive UI

**No distractions! Only essentials!**
UI is built solely on the concept of creating an order for a new customer as fast as possible:

 - Most of the UI elements are centered so you spend less time dragging the cursor across the screen
 - One-screen creation of order (your cursor stays at the center of the screen)
 - Settings facet is used to store your custom column orders and sorting settings (multi sorting is enabled by default!)
 - Easy to interpret badges are used for differentiation between complete and incomplete orders
 - Profile links are embedded into orders list so you can jump straight to a conversation with a customer from order list
   
 A notification on log in provides you with useful information:
<figure>
    <img src="https://github.com/user-attachments/assets/6cb3d407-3c0d-4b25-ab0a-ed0d4a90b243">
    <figcaption>Main screen, showing on log in (some personal info censored). Notification shows the number of active orders and number of hours since last heads cleaning. Active orders are marked with "Pending" badges for easier separation. "Profile" column shows either a clickable link or plain text (if customer doesn't have http/https style profile link)</figcaption>
</figure>


<figure>
    <img src="https://github.com/user-attachments/assets/3e02781b-0086-4bbe-918c-6fa914dd1e66    ">
    <figcaption>Customers list screen. "Profile", "Total paid" and "Total minutes" are automatically generated every time from Orders</figcaption>
</figure>

# Technical data and service information collection and management

DigFox provides you a set of tools to track your active VCR heads wear and time past cleaning (only one active VCR is supported at the moment).  All expenses (advertising, equipment purchases, etc.) are used for calculation of the net profit. 
If the time since last head cleaning exceeds 100 hours, a non-closeable warning message will appear at the top of the screen.

<figure>
    <img src="https://github.com/user-attachments/assets/a3b7f954-9a30-40c5-b60a-00475aca63ac">
    <figcaption>Purely technical-oriented screen. You track your VCR's heads wear on the left and your spendings on the right... VCR models are stored in VCRModel enum. Expense types are stored in ExpensesType enum </figcaption>
</figure>

# Extensive statistics and metrics
Statistics from all orders is used to give you the best experience. Easy-to-read donut diagram shows a percentage of each media type you've ever went through, hour price (derived from net profit) is calculated so you can adjust your pricing policies accordingly.
 <figure>
    <img src="https://github.com/user-attachments/assets/9404da5d-5fd5-4965-aadb-8017921c04c1">
    <figcaption>Statistics screen. Interactive donut diagram shows distribution by media formats. Textboxes on the right display more detailed statistics, including net profit and exact quantities of each format's mediums. Statistics is pulled up from Stats DTO entity using StatsService bean. Media types are stored in MediaTypes enum</figcaption>
</figure>

