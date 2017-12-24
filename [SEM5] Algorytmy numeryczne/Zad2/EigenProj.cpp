// EigenProj.cpp : Defines the entry point for the console application.
//


#include "stdafx.h"
#include <iostream>
#include <Eigen/Dense>
#include <vector>
#include <random>
#include <fstream>
#include <chrono>
using namespace Eigen;
using namespace std;

int MIN_SIZE = 2;
int MAX_SIZE = 30;
int TEST_SAME_SIZE = 1;
int RANDOM_MAX = 50;

void test(MatrixXd A, MatrixXd B, MatrixXd C, VectorXd vX, VectorXd vB, int n, ofstream& file, ofstream& czasyFile) {
	IOFormat CommaInitFmt(StreamPrecision, DontAlignCols, " ", " ", "", "", "", "");
	// Check Time

	double time[5];

	auto start = chrono::high_resolution_clock::now();
	A*vX;
	auto finish = chrono::high_resolution_clock::now();
	chrono::duration<double> elapsed = finish - start;
	time[0] = elapsed.count();

	start = chrono::high_resolution_clock::now();
	((A + B + C)*vX);
	finish = chrono::high_resolution_clock::now();
	elapsed = finish - start;
	time[1] = elapsed.count();

	start = chrono::high_resolution_clock::now();
	(A*(B*C));
	finish = chrono::high_resolution_clock::now();
	elapsed = finish - start;
	time[2] = elapsed.count();

	start = chrono::high_resolution_clock::now();
	(A.partialPivLu().solve(vB));
	finish = chrono::high_resolution_clock::now();
	elapsed = finish - start;
	time[3] = elapsed.count();

	start = chrono::high_resolution_clock::now();
	(A.fullPivLu().solve(vB));
	finish = chrono::high_resolution_clock::now();
	elapsed = finish - start;
	time[4] = elapsed.count();

	file << n << endl;
	file << (A*vX).format(CommaInitFmt) << endl;
	file << ((A + B + C)*vX).format(CommaInitFmt) << endl;
	file << (A*(B*C)).format(CommaInitFmt) << endl;
	file << (A.partialPivLu().solve(vB)).format(CommaInitFmt) << endl;
	file << (A.fullPivLu().solve(vB)).format(CommaInitFmt) << endl;
	czasyFile << n << ";" << time[0] << ";" << time[1] << ";" << time[2] << ";" << time[3] << ";" << time[4] << ";" << endl;
}



int main(int, char *[])
{
	// SETUP GENERATORS FOR RANDOM NUMBERS
	vector<int> numerators; //to store the random numbers
	vector<int> denominators;
	vector<int> variables;

	random_device rd; //seed generator
	mt19937_64 generator{ rd() }; //generator initialized with seed from rd
	uniform_int_distribution<> dist_num{ 1, 100 }; //the range is inclusive, so this produces numbers in range [0, 10), same as before
	uniform_int_distribution<> dist_den{ 1, 100 };
	// END-OF-SETUP

	// otwieramy plik z danymi na temat macierzy
	ofstream czasyFraction("czasyFraction.csv");
	ofstream czasyDouble("czasyDouble.csv");
	ofstream czasyFloat("czasyFloat.csv");
	ofstream daneFraction("daneFractioncpp.txt");
	ofstream daneFloat("daneFloatcpp.txt");
	ofstream daneDouble("daneDoublecpp.txt");
	ofstream wynikiFraction("wynikiFractioncpp.txt");
	ofstream wynikiFloat("wynikiFloatcpp.txt");
	ofstream wynikiDouble("wynikiDoublecpp.txt");

	for (int i = MIN_SIZE; i < MAX_SIZE; i++) {
		for (int t = 0; t < TEST_SAME_SIZE; t++) { //for Fraction
			daneFraction << i << endl;
			// WYPELNIAM WARTOSCI DO MACIERZY A
			for (int j = 0; j < i*i; j++) {
				numerators.push_back(dist_num(generator));
				denominators.push_back(dist_den(generator));
			}

			int ind = 0;
			MatrixXd A(i, i);
			for (int row = 0; row < i; row++) {
				for (int col = 0; col < i; col++) {
					daneFraction << numerators[ind] << "/" << denominators[ind] << " ";
					A(row, col) = (double)numerators[ind] / denominators[ind];
					ind++;
				}
				daneFraction << "\n";
			}
			daneFraction << endl;
			//cout << "\nMATRIX A: " << i << "x" << i << endl << A << endl;

			numerators.clear();
			denominators.clear();

			for (int j = 0; j < i*i; j++) {
				numerators.push_back(dist_num(generator));
				denominators.push_back(dist_den(generator));
			}

			ind = 0;
			MatrixXd B(i, i);
			for (int row = 0; row < i; row++) {
				for (int col = 0; col < i; col++) {
					daneFraction << numerators[ind] << "/" << denominators[ind] << " ";
					B(row, col) = (double)numerators[ind] / denominators[ind];
					ind++;
				}
				daneFraction << "\n";
			}
			daneFraction << endl;


			numerators.clear();
			denominators.clear();

			//cout << "\nMATRIX B: " << i << "x" << i << endl << B << endl;

			for (int j = 0; j < i*i; j++) {
				numerators.push_back(dist_num(generator));
				denominators.push_back(dist_den(generator));
			}

			ind = 0;
			MatrixXd C(i, i);
			for (int row = 0; row < i; row++) {
				for (int col = 0; col < i; col++) {
					daneFraction << numerators[ind] << "/" << denominators[ind] << " ";
					C(row, col) = (double)numerators[ind] / denominators[ind];
					ind++;
				}
				daneFraction << "\n";
			}
			daneFraction << endl;

			numerators.clear();
			denominators.clear();

			//cout << "\nMATRIX C: " << i << "x" << i << endl << C << endl;


			for (int j = 0; j < i; j++) {
				numerators.push_back(dist_num(generator));
				denominators.push_back(dist_den(generator));
			}

			ind = 0;
			VectorXd vX(i);
			for (int j = 0; j < i; j++) {
				daneFraction << numerators[ind] << "/" << denominators[ind] << " ";
				vX(j) = (double)numerators[ind] / denominators[ind];
				ind++;
			}
			daneFraction << endl;

			numerators.clear();
			denominators.clear();

			//cout << "\nVECTOR X: " << vX << endl;

			for (int j = 0; j < i; j++) {
				numerators.push_back(dist_num(generator));
				denominators.push_back(dist_den(generator));
			}

			ind = 0;
			VectorXd vB(i);
			for (int j = 0; j < i; j++) {
				daneFraction << numerators[ind] << "/" << denominators[ind] << " ";
				vB(j) = (double)numerators[ind] / denominators[ind];
				ind++;
			}
			daneFraction << endl;


			numerators.clear();
			denominators.clear();

			//cout << "\nVECTOR B: " << vB << endl;

			test(A, B, C, vX, vB, i, wynikiFraction, czasyFraction);

		}


		//////////////////////////////////////////////////////////////////////////////////////////////////
		for (int t = 0; t < TEST_SAME_SIZE; t++) { //for float
			daneFloat << i << endl;
			// WYPELNIAM WARTOSCI DO MACIERZY A

			int ind = 0;
			MatrixXd A(i, i);
			for (int row = 0; row < i; row++) {
				for (int col = 0; col < i; col++) {
					float r = static_cast <float> (rand()) / (static_cast <float> (RAND_MAX / RANDOM_MAX));
					daneFloat << r << " ";
					A(row, col) = r;
					ind++;
				}
				daneFloat << "\n";
			}
			daneFloat << endl;
			//cout << "\nMATRIX A: " << i << "x" << i << endl << A << endl;

			// WYPELNIAM WARTOSCI DO MACIERZY B
			ind = 0;
			MatrixXd B(i, i);
			for (int row = 0; row < i; row++) {
				for (int col = 0; col < i; col++) {
					float r = static_cast <float> (rand()) / (static_cast <float> (RAND_MAX / RANDOM_MAX));
					daneFloat << r << " ";
					B(row, col) = r;
					ind++;
				}
				daneFloat << "\n";
			}
			daneFloat << endl;

			//cout << "\nMATRIX B: " << i << "x" << i << endl << B << endl;

			// WYPELNIAM WARTOSCI DO MACIERZY C
			ind = 0;
			MatrixXd C(i, i);
			for (int row = 0; row < i; row++) {
				for (int col = 0; col < i; col++) {
					float r = static_cast <float> (rand()) / (static_cast <float> (RAND_MAX / RANDOM_MAX));
					daneFloat << r << " ";
					C(row, col) = r;
					ind++;
				}
				daneFloat << "\n";
			}
			daneFloat << endl;

			//cout << "\nMATRIX C: " << i << "x" << i << endl << C << endl;

			//WEKTOR X
			ind = 0;
			VectorXd vX(i);
			for (int j = 0; j < i; j++) {
				float r = static_cast <float> (rand()) / (static_cast <float> (RAND_MAX / RANDOM_MAX));
				daneFloat << r << " ";
				vX(j) = r;
				ind++;
			}
			daneFloat << endl;

			//cout << "\nVECTOR X: " << vX << endl;

			//WEKTOR B
			ind = 0;
			VectorXd vB(i);
			for (int j = 0; j < i; j++) {
				float r = static_cast <float> (rand()) / (static_cast <float> (RAND_MAX / RANDOM_MAX));
				daneFloat << r << " ";
				vB(j) = r;
				ind++;
			}
			daneFloat << endl;

			//cout << "\nVECTOR B: " << vB << endl;

			test(A, B, C, vX, vB, i, wynikiFloat, czasyFloat);

		}

		///////////////////////////////////////////////////////////////////////////////////////////////////
		for (int t = 0; t < TEST_SAME_SIZE; t++) { //for double
			daneDouble << i << endl;
			// WYPELNIAM WARTOSCI DO MACIERZY A

			int ind = 0;
			MatrixXd A(i, i);
			for (int row = 0; row < i; row++) {
				for (int col = 0; col < i; col++) {
					double r = static_cast <double> (rand()) / (static_cast <double> (RAND_MAX / RANDOM_MAX));
					daneDouble << r << " ";
					A(row, col) = r;
					ind++;
				}
				daneDouble << "\n";
			}
			daneDouble << endl;
			//cout << "\nMATRIX A: " << i << "x" << i << endl << A << endl;

			// WYPELNIAM WARTOSCI DO MACIERZY B
			ind = 0;
			MatrixXd B(i, i);
			for (int row = 0; row < i; row++) {
				for (int col = 0; col < i; col++) {
					double r = static_cast <double> (rand()) / (static_cast <double> (RAND_MAX / RANDOM_MAX));
					daneDouble << r << " ";
					B(row, col) = r;
					ind++;
				}
				daneDouble << "\n";
			}
			daneDouble << endl;

			//cout << "\nMATRIX B: " << i << "x" << i << endl << B << endl;

			// WYPELNIAM WARTOSCI DO MACIERZY C
			ind = 0;
			MatrixXd C(i, i);
			for (int row = 0; row < i; row++) {
				for (int col = 0; col < i; col++) {
					double r = static_cast <double> (rand()) / (static_cast <double> (RAND_MAX / RANDOM_MAX));
					daneDouble << r << " ";
					C(row, col) = r;
					ind++;
				}
				daneDouble << "\n";
			}
			daneDouble << endl;

			//cout << "\nMATRIX C: " << i << "x" << i << endl << C << endl;

			//WEKTOR X
			ind = 0;
			VectorXd vX(i);
			for (int j = 0; j < i; j++) {
				double r = static_cast <double> (rand()) / (static_cast <double> (RAND_MAX / RANDOM_MAX));
				daneDouble << r << " ";
				vX(j) = r;
				ind++;
			}
			daneDouble << endl;

			//cout << "\nVECTOR X: " << vX << endl;

			//WEKTOR B
			ind = 0;
			VectorXd vB(i);
			for (int j = 0; j < i; j++) {
				double r = static_cast <double> (rand()) / (static_cast <double> (RAND_MAX / RANDOM_MAX));
				daneDouble << r << " ";
				vB(j) = r;
				ind++;
			}
			daneDouble << endl;

			//cout << "\nVECTOR B: " << vB << endl;

			test(A, B, C, vX, vB, i, wynikiDouble, czasyDouble);

		}
	}

	daneFraction.close();
	daneFloat.close();
	daneDouble.close();
	wynikiFraction.close();
	wynikiFloat.close();
	wynikiDouble.close();
	cout << "SKONCZONE";

	cin.get();
}

