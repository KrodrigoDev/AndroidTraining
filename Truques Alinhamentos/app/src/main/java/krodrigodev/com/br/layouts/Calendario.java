package krodrigodev.com.br.layouts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.util.Calendar;

public class Calendario extends AppCompatActivity {

    private MaterialCalendarView calendarView;
    private String meses[] = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        calendarView = findViewById(R.id.calendarView);

        // definindo limites
        calendarView.state().edit().
                setMinimumDate(CalendarDay.from(2023,9,17)).
                setMaximumDate(CalendarDay.from(2025,1,1)).
                commit();

        // mudando os meses por meio de um array
        calendarView.setTitleMonths(meses);

        // capturando o mês
        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                Log.d("Data:","Valor: " + (date.getMonth() + 1)  +"/"+ date.getYear());
            }
        });

    }
}