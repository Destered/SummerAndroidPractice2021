package com.dester.summerandroidpractice2021.data.models

data class Events(
    var years: MutableList<Year> = mutableListOf<Year>()
)
{
    fun addYear(year: Int, description: String?){
        this.years.add(Year(year, mutableListOf<Mounth>(), description))
    }

    private fun sortDays(mounth: Mounth){
        for(i in 0..mounth.days.size){
            for(j in 0..mounth.days.size - 1){
                if(mounth.days[i].date.eventDay!! > mounth.days[j].date.eventDay!!){
                    var temp = mounth.days[i]
                    mounth.days[i] = mounth.days[j]
                    mounth.days[j] = temp
                }
            }
        }
    }

    private fun sortMounts(year: Year){
        for(i in 0..year.mounths.size){
            for(j in 0..year.mounths.size - 1){
                if(year.mounths[i].mounth > year.mounths[j].mounth){
                    var temp = year.mounths[i]
                    year.mounths[i] = year.mounths[j]
                    year.mounths[j] = temp
                }
            }
        }
    }

    private fun sortYears(events: Events){
        for(i in 0..events.years.size){
            for(j in 0..events.years.size - 1){
                if(events.years[i].year > events.years[j].year){
                    var temp = events.years[i]
                    events.years[i] = events.years[j]
                    events.years[j] = temp
                }
            }
        }
    }

    fun sort(){
        sortYears(this)
        for (i in 0..this.years.size){
            sortMounts(this.years[i])
            for (j in 0..this.years[i].mounths.size){
                sortDays(this.years[i].mounths[j])
            }
        }
    }
}
