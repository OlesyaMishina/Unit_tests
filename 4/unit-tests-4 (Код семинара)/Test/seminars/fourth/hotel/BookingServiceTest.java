package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {
        @Test
        void testBooking() {
            HotelService hotelService = mock(HotelService.class);
            BookingService bookingService = new BookingService(hotelService);
            when(bookingService.bookRoom(4)).thenReturn(true);

            boolean result = bookingService.bookRoom(4);

            assertTrue(result);
        }

        @Test
        void testBookingNegative() {
            HotelService hotelService = mock(HotelService.class);
            BookingService bookingService = new BookingService(hotelService);
            when(bookingService.bookRoom(3)).thenReturn(false);

            boolean result = bookingService.bookRoom(3);

            assertFalse(result);
        }
    }
