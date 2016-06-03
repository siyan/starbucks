package com.sywood.starbucks.ben.SortAlgorithms;

public class InsertionSort {
    private static String[] sort(String[] array){
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[i-1]) < 0){
                String temp = array[i];
                int j;
                for (j = i-1; j >= 0 && temp.compareTo(array[j]) < 0; j--) {
                    array[j+1] = array[j];
                }
                array[j+1] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args){
        String[] test = new String[]{
                "Stocker, Thomas F., Dahe Qin, and Gian-Kasper. \"Climate Change 2013.\"Cambridge University Press. Intergovernmental Panel on Climate Change, 2013. Web. 14 May 2016.\n",
                "Miller, Brandon. \"2015 Is Warmest Year on Record, NOAA and NASA Say.\"CNN. Cable News Network, 20 Jan. 2016. Web. 14 May 2016.\n",
                "Craigie, Kathleen. Grade 10 TOPS Biodiversity Study Procedure Manual. N.p.: n.p., n.d. Print.\n",
                "University of Guelph. \"Balsamfir.\" Balsamfir. University of Guelph, 2016. Web. 15 May 2016\n",
                "National Plants Data Team. \"Balsam Fir\" United States Resource Conservation Service (2016): n. pag. Natural Resources Conservation Service. United States Department of Agriculture, 2016. Web. 15 May 2016.\n",
                "Mauro, Bill. \"Balsam Fir.\" Ontario.ca. Queen's Printer for Ontario, 11 Aug. 2014. Web. 15 May 2016.\n",
                "Faculty of Natural Resource Management. \"Abies Balsamea - Balsam Fir.\"Abies Balsamea - Balsam Fir. Faculty of Natural Resource Management, Lakehead University, 2011. Web. 27 May 2016.\n",
                "C, Mfuredi. \"Balsam Fir.\" Species: Balsam Fir (Abies Balsamea) (n.d.): n. pag.Pennsylvania Natural Heritage Program. Department of Conservation and Natural Resources, 2006. Web. 16 May 2016.\n",
                "Kaulfu, Susanne. \"Forest Fire Prevention.\" Sci Am Scientific American (2003): 336. Waldwissen.net. Forest Research Institute of Baden-Württemberg, 2011. Web. 15 May 2016\n",
                "Lakehead University. \"Forest Fires - Prevention.\" Forest Fires - Prevention. Lakehead University, 2014. Web. 18 May 2016.\n",
                "United States Department of Agriculture. \"Abies Balsamea.\" Abies Balsamea. U.S Forest Service, n.d. Web. 16 May 2016.\n",
                "Natural Resources Canada. \"Fire Ecology.\" Natural Resources Canada. Government of Canada, 1 Feb. 2016. Web. 17 May 2016.\n",
                "DairyGood. \"What Is the Carbon Footprint of a Gallon of Milk.\" DairyGood. Dairy Management Inc, 2014. Web. 14May 2016.\n",
                "Thomas, Gregory J., Jennie Popp, Darin Nutter, David Shonnard, Richard Ulrich, Marty Matlock, Dae Soo Kim, Zara Neiderman, Nathan Kemper, Cashion East, and Felix Adom. \"Greenhouse Gas Emissions from Milk Production and Consumption in the United States: A Cradle-to-grave Life Cycle Assessment circa 2008.\" ResearchGate. International Dairy Journal, 31 Apr. 2013. Web. 16 May 2016.\n",
                "McIntyre, Tobi. \"Forest Fire Fast Facts: Canadian Geographic In Depth.\"Forest Fire Fast Facts: Canadian Geographic In Depth. Canadian Geographic Enterprises, July-Aug. 2003. Web. 28 May 2016."};
        test = sort(test);
        for (String num : test){
            System.out.print(num);
        }
    }
}
